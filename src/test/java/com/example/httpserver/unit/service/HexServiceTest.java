package com.example.httpserver.unit.service;

import com.example.httpserver.service.IHexService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HexServiceTest {
    @Autowired
    IHexService hexService;

    @Test
    public void shouldReturnOKWhenHexCreatedSuccessfully(){
        //act
        ResponseEntity<?> currentResponse = hexService.getRandomHex();
        //assert
        assertEquals(HttpStatus.OK, currentResponse.getStatusCode());
    }

    @Test
    public void shouldReturn32HexSuccessfully(){
        //act
        ResponseEntity<?> currentResponse = hexService.getRandomHex();
        //assert
        assertEquals(32, Objects.requireNonNull(currentResponse.getBody()).toString().length());
    }
}
