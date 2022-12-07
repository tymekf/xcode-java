package com.feil.tymek.xcodejava.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.feil.tymek.xcodejava.model.Currencies;
import java.io.IOException;
import java.math.BigDecimal;

@RestController
@RequestMapping("/currencies")
public class CurrenciesController {

    Currencies currencies = new Currencies();

    @PostMapping("/get-current-currency-value-command")
    public String getCurrencyValue(@RequestBody String currencyCode) throws IOException {
        String trimmedCurrencyCode = currencyCode.substring(currencyCode.lastIndexOf("\"") - 3, currencyCode.lastIndexOf("\""));
        BigDecimal currencyValue = currencies.fetchSpecificCurrencyRate(trimmedCurrencyCode);
        return "{\n     value: " + currencyValue + "\n}";
    }

}
