package com.feil.tymek.xcodejava.dto;

import java.util.List;

public class NumbersToBeSorted {

    private List<Integer> numbers;
    private String order;

    public NumbersToBeSorted(List<Integer> numbers, String order) {
        this.numbers = numbers;
        this.order = order;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public String getOrder() {
        return order;
    }
}