package com.feil.tymek.xcodejava.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.feil.tymek.xcodejava.model.Request;
import java.util.Comparator;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/numbers")
public class NumbersController {

    @PostMapping("/sort-command")
    public ResponseEntity sortIntegerList(@RequestBody Request request) {

        if (request.getOrder().contains("ASC")) {
            return ResponseEntity.ok(request.getNumbers().stream().sorted(Comparator.comparingInt(i -> i)).collect(Collectors.toList()));
        } else if (request.getOrder().contains("DESC")) {
            return ResponseEntity.ok(request.getNumbers().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        } else {
            return null;
        }
    }

}
