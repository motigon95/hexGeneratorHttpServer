package com.example.httpserver.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class HexService implements IHexService{
    @Override
    public ResponseEntity<String> getRandomHex() {
        String hex = UUID.randomUUID().toString().replace("-","").toUpperCase();
        return new ResponseEntity<>(hex, HttpStatus.OK);
      }
}
