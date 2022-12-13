package com.feil.tymek.xcodejava.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.feil.tymek.xcodejava.service.NumbersToBeSorted;

import java.util.Comparator;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/numbers")
public class NumbersController {
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/sort-command")
    public ResponseEntity sortIntegerList(@RequestBody NumbersToBeSorted numbersToBeSorted) {

        if (numbersToBeSorted.getOrder().contains("ASC")) {
            return ResponseEntity.ok(numbersToBeSorted.getNumbers().stream().sorted(Comparator.comparingInt(i -> i)).collect(Collectors.toList()));
        } else if (numbersToBeSorted.getOrder().contains("DESC")) {
            return ResponseEntity.ok(numbersToBeSorted.getNumbers().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        } else {
            return null;
        }
    }
}