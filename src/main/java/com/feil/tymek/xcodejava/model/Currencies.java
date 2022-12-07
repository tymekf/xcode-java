package com.feil.tymek.xcodejava.model;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Currencies {

    public void fetchCurrencyRate() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("http://api.nbp.pl/api/exchangerates/tables/A?format=json")).build();

        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }

    public BigDecimal fetchSpecificCurrencyRate(String currencyCode) throws IOException {

        BigDecimal currencyValue = null;

        URL url = new URL("http://api.nbp.pl/api/exchangerates/tables/A?format=json");
        JSONTokener tokener = new JSONTokener(url.openStream());
        JSONArray jsonArray = new JSONArray (tokener);
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        JSONArray rates = jsonObject.getJSONArray("rates");
        boolean isFound = false;
        for (int i = 0; i < rates.length(); i++) {
            if (rates.getJSONObject(i).get("code").equals(currencyCode)) {
                currencyValue = rates.getJSONObject(i).getBigDecimal("mid");
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("nie ma takiej waluty");
        }
        return currencyValue;
    }


}
