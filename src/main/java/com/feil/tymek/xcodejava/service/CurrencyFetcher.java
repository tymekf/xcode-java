package com.feil.tymek.xcodejava.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;

public class CurrencyFetcher {

    public BigDecimal fetchSpecificCurrencyRate(String currencyCode) {

        BigDecimal currencyValue = null;
        URL url;
        JSONTokener tokener;

        try {
            url = new URL("http://api.nbp.pl/api/exchangerates/tables/A?format=json");
            tokener = new JSONTokener(url.openStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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