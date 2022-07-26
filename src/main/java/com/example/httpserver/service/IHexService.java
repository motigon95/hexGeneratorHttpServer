package com.example.httpserver.service;

import org.springframework.http.ResponseEntity;

public interface IHexService {

    ResponseEntity<String> getRandomHex();

}
