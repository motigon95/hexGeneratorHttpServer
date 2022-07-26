package com.example.httpserver.integration;

import com.example.httpserver.service.IHexService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Objects;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class HexControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    IHexService hexService;

    @Test
    public void shouldReturnHttpStatusOk() throws Exception {
        //act & assert
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnAnHexString() throws Exception {
        //act
        MvcResult response = mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        //assert
        assertEquals(32, response.getResponse().getContentAsString().length());
    }



}
