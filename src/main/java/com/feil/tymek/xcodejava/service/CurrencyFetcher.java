package com.feil.tymek.xcodejava.service;

import java.util.*;

import com.feil.tymek.xcodejava.dto.NBPResponse;
import com.feil.tymek.xcodejava.dto.Rate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class CurrencyFetcher {

    public static final String NBP_HTTP = "http://api.nbp.pl/api/exchangerates/tables/A?format=json";
    private final RestTemplate restTemplate;

    public CurrencyFetcher(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Optional<Rate> fetchASpecificCurrency(String currencyCode) {
        ResponseEntity<List<NBPResponse>> exchange = fetchRates();
        NBPResponse body = exchange.getBody().get(0);
        return getCorrectCurrency(currencyCode, body);
    }

    private ResponseEntity<List<NBPResponse>> fetchRates() {
        return restTemplate.exchange(NBP_HTTP,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });
    }

    private static Optional<Rate> getCorrectCurrency(String currencyCode, NBPResponse body) {
        return body
                .getRates()
                .stream()
                .filter(rate -> rate.getCode().equals(currencyCode))
                .findFirst();
    }

}