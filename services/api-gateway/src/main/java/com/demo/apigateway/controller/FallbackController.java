package com.demo.apigateway.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

//    @GetMapping("/healthservice/fallback")
//    public ResponseEntity<String> fallbackProductService() {
//        return ResponseEntity.ok("Health service is unavailable. Please try again later.");
//    }

    @GetMapping("/healthservice/fallback")
    public ResponseEntity<String> fallbackGet() {
        String fallbackMessage = "Fallback GET response for health-service";
        return ResponseEntity.status(HttpStatus.OK).body(fallbackMessage);
    }

    @PostMapping("/healthservice/fallback")
    public ResponseEntity<String> fallbackPost() {
        String fallbackMessage = "Fallback POST response for health-service";
        return ResponseEntity.status(HttpStatus.OK).body(fallbackMessage);
    }





}
