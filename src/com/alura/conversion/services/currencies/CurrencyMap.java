package com.alura.conversion.services.currencies;

import java.util.LinkedHashMap;
import java.util.Map;

public class CurrencyMap {
    public static Map<String, String> currency = new LinkedHashMap<>();

    static {
        currency.put("1", "USD United States Dollar");
        currency.put("2", "EUR Euro");
        currency.put("3", "JPY Japanese Yen");
        currency.put("4", "INR Indian Rupee");
        currency.put("5", "COP Colombian Peso");
        currency.put("6", "ARS Argentine Peso");
        currency.put("7", "MXN Mexican Peso");
        currency.put("8", "CLP Chilean Peso");
        currency.put("9", "BRL Brazilian Real");
        currency.put("10", "PEN Peruvian Sol");
        currency.put("H", "History");
        currency.put("0", "Exit");
    }
}
