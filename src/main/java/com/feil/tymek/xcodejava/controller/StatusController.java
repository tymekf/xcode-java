package com.feil.tymek.xcodejava.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/status")
public class StatusController {

    @GetMapping("/ping")
    public String tableTennis() {
        return "pong";
    }

}