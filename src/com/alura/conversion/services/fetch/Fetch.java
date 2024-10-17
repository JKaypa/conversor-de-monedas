package com.alura.conversion.services.fetch;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Fetch {
        private static final String apiKey = "3325688d8bdd806d8276c3ae";
    private static final String endpoint = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/";

    public static String load (String baseCurrency, String targetCurrency, String amount) {
        URI uri = URI.create(endpoint + baseCurrency + "/" + targetCurrency + "/" + amount);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
        try {
            HttpResponse <String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();

        } catch (IOException | InterruptedException e) {
            return e.getMessage();
        }
    }
}
