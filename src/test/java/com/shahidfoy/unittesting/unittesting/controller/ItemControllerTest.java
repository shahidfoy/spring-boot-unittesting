package com.shahidfoy.unittesting.unittesting.controller;

import com.shahidfoy.unittesting.unittesting.business.ItemBusinessService;
import com.shahidfoy.unittesting.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value=ItemController.class)
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService itemBusinessService;

    @Test
    public void dummyItem_basic() throws Exception {
        // call GET /dummy-item
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "\"id\": 1,\n" +
                        "\"name\": \"Ball\",\n" +
                        "\"price\": 10,\n" +
                        "\"quantity\": 100\n" +
                        "}"))
                .andReturn();
    }

    @Test
    public void itemFromBusinessService_basic() throws Exception {

        when(itemBusinessService.retrieveHardcodedItem()).thenReturn(
                new Item(2, "Item2", 10, 10)
        );

        // call GET /dummy-item
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id: 2,name:Item2,price: 10,quantity: 10}"))
                .andReturn();
    }

    @Test
    public void retrieveAllItems_basic() throws Exception {

        when(itemBusinessService.retrieveAllItems()).thenReturn(
                Arrays.asList(
                        new Item(2, "Item2", 10, 10),
                        new Item(3, "Item3", 20, 20)
                )
        );

        // call GET /all-items-from-database
        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id: 2,name:Item2,price: 10,quantity: 10},{id: 3,name:Item3,price: 20,quantity: 20}]"))
                .andReturn();
    }
}