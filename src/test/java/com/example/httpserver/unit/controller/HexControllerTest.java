package com.example.httpserver.unit.controller;

import com.example.httpserver.controller.HexController;
import com.example.httpserver.service.IHexService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HexControllerTest {

    @Mock
    IHexService hexService;

    @InjectMocks
    private HexController hexController;



    @Test
    void shouldReturnOKWhenHexCreatedSuccessfully() {
        //arrange
        String hex = UUID.randomUUID().toString().replace("-","").toUpperCase();
        when(hexService.getRandomHex()).thenReturn(new ResponseEntity<>(hex, HttpStatus.OK));
        //act
        ResponseEntity<?> currentResponse = hexController.getRandomHex();
        //assert
        verify((hexService), atLeastOnce()).getRandomHex();
        assertEquals(HttpStatus.OK, currentResponse.getStatusCode());
    }

    @Test
    void shouldReturn32HexSuccessfully() {
        //arrange
        String hex = UUID.randomUUID().toString().replace("-","").toUpperCase();
        when(hexService.getRandomHex()).thenReturn(new ResponseEntity<>(hex, HttpStatus.OK));
        //act
        ResponseEntity<?> currentResponse = hexController.getRandomHex();
        //assert
        verify((hexService), atLeastOnce()).getRandomHex();
        assertEquals(32, Objects.requireNonNull(currentResponse.getBody()).toString().length());
    }
}
