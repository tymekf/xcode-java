package com.feil.tymek.xcodejava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class XcodeJavaApplication {
    public static void main(String[] args) {
        SpringApplication.run(XcodeJavaApplication.class, args);
        System.out.println("app started");
    }
}