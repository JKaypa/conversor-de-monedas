import com.alura.conversion.enums.Action;
import com.alura.conversion.models.Conversion;
import com.alura.conversion.models.ConversionDTO;
import com.alura.conversion.services.currencies.CurrencyMap;
import com.alura.conversion.services.fetch.Fetch;
import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MainConversion {
    private static final String div = "***************";
    private  static final Map<String, String> currencies = CurrencyMap.currency;
    private static final Scanner input = new Scanner(System.in);
    private static final Gson serializer = new GsonBuilder().setPrettyPrinting().create();
    private static final String filepath = "src/conversions.json";

    public static void main(String[] args) {
        runCurrencyConversionProgram();
    }

    static void showOptions() {
        currencies.forEach((key, value) -> {
            System.out.printf("%s. %s%n", key, value);
        });
        System.out.println("\nPlease select an option:");
    }

    static Action performAction(String option) {
        if (option == null) {
            System.out.println("Ø Please, select a valid option \n");
            return Action.CONTINUE;
        }
        if (option.equals("Exit")) {
            return Action.EXIT;
        }
        if (option.equals("History")){
            showHistory();
            return Action.CONTINUE;
        }
        return Action.NO_ACTION;

    }

    static <T> void writeJsonFile (T object) {
        String json = serializer.toJson(object);
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        JsonArray jsonArray = readJsonFile();
        jsonArray.add(jsonObject);
        try {
            FileWriter writer = new FileWriter(filepath);
            writer.write(serializer.toJson(jsonArray));
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static JsonArray readJsonFile () {
        try {
            FileReader reader = new FileReader(filepath);
            return JsonParser.parseReader(reader).getAsJsonArray();
        } catch (FileNotFoundException | IllegalStateException e) {
            return new JsonArray();
        }
    }

    static List<Conversion> parseJsonFileToListObject() {
        JsonArray jsonConversionHistory = readJsonFile();
        List<Conversion> history = new ArrayList<>();

        jsonConversionHistory.forEach(conversion -> {
            JsonObject jsonConversionObject = conversion.getAsJsonObject();

            ConversionDTO dto =  serializer.fromJson(jsonConversionObject, ConversionDTO.class);
            Conversion conversionHistory = new Conversion(dto, null);

            history.add(conversionHistory);
        });

        return history;
    }

    static void showHistory() {
        List<Conversion> conversionHistory =  parseJsonFileToListObject();

        System.out.println(div + " History " + div + "\n");
        for (Conversion history : conversionHistory) {
            System.out.println(history.toString());
        }
    }

    static void runCurrencyConversionProgram(){
        String baseOption;
        String targetOption;

        while (true) {
            System.out.println("\n" + div + " Currency Converter " + div + "\n");
            showOptions();

            baseOption = input.nextLine().toUpperCase();
            String option1 = currencies.get(baseOption);
            Action action;
            action = performAction(option1);

            if (action == Action.CONTINUE) continue;
            if(action == Action.EXIT) return;

            System.out.println("You selected " + option1);
            System.out.println("\nInsert the amount of " + option1 + " you want to convert from:");
            String userAmount = input.nextLine();
            double amount;

            try {
                amount = Double.parseDouble(userAmount);

            } catch (NumberFormatException e) {
                System.out.println("Currency amount is not valid");
                continue;
            }

            String preciseAmount = String.format("%.4f", amount);
            System.out.println("Select target currency you want to convert to:");
            showOptions();

            targetOption = input.nextLine().toUpperCase();
            String option2 = currencies.get(targetOption);
            action = performAction(option2);

            if (action == Action.CONTINUE) continue;
            if(action == Action.EXIT) return;

            System.out.println("You selected " + option2);

            String baseCurrency = currencies.get(baseOption).split(" ")[0];
            String targetCurrency = currencies.get(targetOption).split(" ")[0];

            String response = Fetch.load(baseCurrency, targetCurrency, preciseAmount);
            ConversionDTO conversion = serializer.fromJson(response, ConversionDTO.class);
            Conversion currencyConversion = new Conversion(conversion, amount);

            System.out.println(currencyConversion.getResult());

            writeJsonFile(currencyConversion);

        }
    }
}
