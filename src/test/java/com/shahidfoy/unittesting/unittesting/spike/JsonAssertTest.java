package com.shahidfoy.unittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\"id\": 1,\"name\": \"Ball\",\"price\": 10,\"quantity\": 100}";

    @Test
    public void jsonAssert_StrictTrue() throws JSONException {
        String expectedResponse = "{\"id\": 1,\"name\": \"Ball\",\"price\": 10,\"quantity\": 100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }

    @Test
    public void jsonAssert_StrictFalse() throws JSONException {
        String expectedResponse = "{\"id\": 1,\"name\": \"Ball\",\"price\": 10}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
}
