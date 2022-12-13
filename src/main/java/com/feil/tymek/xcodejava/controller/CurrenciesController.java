package com.feil.tymek.xcodejava.controller;

import com.feil.tymek.xcodejava.dto.Rate;
import com.feil.tymek.xcodejava.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.Optional;

@RestController
@RequestMapping("/currencies")
public class CurrenciesController {

    private final CurrencyFetcher currencyFetcher = new CurrencyFetcher(new RestTemplate());

    @PostMapping("/get-current-currency-value-command")
    public ResponseEntity<?> getCurrencyValue(@RequestBody String currencyCode) {
        String trimmedCurrencyCode = currencyCode.substring(currencyCode.lastIndexOf("\"") - 3, currencyCode.lastIndexOf("\""));
        Optional<Rate> rate = currencyFetcher.fetchASpecificCurrency(trimmedCurrencyCode);
        if (rate.isPresent()) {
            return ResponseEntity.ok(rate.get().getMid());
        }
        return ResponseEntity.ok(HttpStatus.NOT_FOUND);
    }
}
