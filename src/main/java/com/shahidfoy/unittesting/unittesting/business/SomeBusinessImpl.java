package com.shahidfoy.unittesting.unittesting.business;

import com.shahidfoy.unittesting.unittesting.data.SomeDataService;

import java.util.Arrays;
import java.util.OptionalInt;

public class SomeBusinessImpl {

    private SomeDataService someDataService;

    public void SomeBusinessImpl(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] data) {
        OptionalInt number = Arrays.stream(data).reduce(Integer::sum);
        return number.orElse(0);
    }

    public int calculateSumUsingDataService() {
        int sum = 0;
        int[] data = someDataService.retrieveAllData();
        for (int value: data) {
            sum += value;
        }
        return sum;
    }
}
