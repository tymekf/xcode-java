package com.feil.tymek.xcodejava.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.feil.tymek.xcodejava.service.CurrencyFetcher;
import java.math.BigDecimal;

@RestController
@RequestMapping("/currencies")
public class CurrenciesController {

    CurrencyFetcher currencyFetcher = new CurrencyFetcher();

    @PostMapping("/get-current-currency-value-command")
    public BigDecimal getCurrencyValue(@RequestBody String currencyCode) {
        String trimmedCurrencyCode = currencyCode.substring(currencyCode.lastIndexOf("\"") - 3, currencyCode.lastIndexOf("\""));
        return currencyFetcher.fetchSpecificCurrencyRate(trimmedCurrencyCode);
    }

}
