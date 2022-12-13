package com.feil.tymek.xcodejava.controller;

import com.feil.tymek.xcodejava.exception.EmptyListException;
import com.feil.tymek.xcodejava.service.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.feil.tymek.xcodejava.dto.NumbersToBeSorted;

@RestController
@RequestMapping("/numbers")
public class NumbersController {

    @Autowired
    private SortingService sortingService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/sort-command")
    public ResponseEntity sortCommand(@RequestBody NumbersToBeSorted numbersToBeSorted) throws EmptyListException {
        if (numbersToBeSorted.getNumbers().isEmpty()) {
            throw new EmptyListException();
        }
        return sortingService.sortIntegerList(numbersToBeSorted);
    }
}