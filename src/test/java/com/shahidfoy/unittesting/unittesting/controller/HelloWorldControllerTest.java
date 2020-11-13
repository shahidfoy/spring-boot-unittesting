package com.shahidfoy.unittesting.unittesting.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value=HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void helloWorld_basic() throws Exception {
        // call GET /hello-world
        RequestBuilder request = MockMvcRequestBuilders
                                    .get("/hello-world")
                                    .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                            .andExpect(status().isOk())
                            .andExpect(content().string("Hello world"))
                            .andReturn();

        // verify "Hello world"
        assertEquals("Hello world", result.getResponse().getContentAsString());
    }
}
