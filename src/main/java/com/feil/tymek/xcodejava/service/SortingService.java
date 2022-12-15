package com.feil.tymek.xcodejava.service;

import com.feil.tymek.xcodejava.dto.NumbersToBeSorted;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class SortingService {

    public ResponseEntity sortIntegerList(@RequestBody NumbersToBeSorted numbersToBeSorted) {
        if (numbersToBeSorted.getOrder().contains("ASC")) {
            return ResponseEntity.ok(numbersToBeSorted.getNumbers().stream().sorted(Comparator.comparingInt(i -> i)).collect(Collectors.toList()));
        } else if (numbersToBeSorted.getOrder().contains("DESC")) {
            return ResponseEntity.ok(numbersToBeSorted.getNumbers().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        } else {
            return ResponseEntity.ok(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
