package com.feil.tymek.xcodejava.service;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;
import java.util.stream.Collectors;

class SortingServiceTest {

    List<Integer> givenList = new ArrayList<>();

    @BeforeEach
    public void setUpAList() {
        Integer firstInteger = (int) (Math.random() * 10);
        Integer secondInteger = (int) (Math.random() * 10);
        Integer thirdInteger = (int) (Math.random() * 10);
        Integer fourthInteger = (int) (Math.random() * 10);
        givenList.add(firstInteger);
        givenList.add(secondInteger);
        givenList.add(thirdInteger);
        givenList.add(fourthInteger);
    }

    @Test
    public void testAscending() {
        List<Integer> sortedList = new ArrayList<>(givenList);
        sortedList.sort(Integer::compareTo);
        givenList = givenList.stream().sorted(Comparator.comparingInt(i->i)).collect(Collectors.toList());
        assertEquals(givenList, sortedList);
    }

    @Test
    public void testDescending() {
        List<Integer> sortedList = givenList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        givenList.sort(Comparator.reverseOrder());
        assertEquals(givenList, sortedList);
    }


}