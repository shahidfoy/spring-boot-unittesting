package com.shahidfoy.unittesting.unittesting.business;

import com.shahidfoy.unittesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeDataServiceStub implements SomeDataService {
    @Override
    public int[] retrieveAllData() {
        return new int[] {1,2,3};
    }
}

public class SomeBusinessStubTest {

    @Test
    public void calculateSumUsingDataService_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.SomeBusinessImpl(new SomeDataServiceStub());
        int result = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, result);
    }
}
