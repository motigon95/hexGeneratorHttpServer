package com.example.httpserver.controller;
import com.example.httpserver.service.IHexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HexController {

    @Autowired
    IHexService hexService;

    @GetMapping
    public ResponseEntity<String> getRandomHex() {
        return hexService.getRandomHex();
    }

}
