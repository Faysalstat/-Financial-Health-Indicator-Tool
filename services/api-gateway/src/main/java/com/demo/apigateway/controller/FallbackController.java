package com.demo.apigateway.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/healthservice/fallback")
    public ResponseEntity<String> fallbackProductService() {
        return ResponseEntity.ok("Health service is unavailable. Please try again later.");
    }



}
