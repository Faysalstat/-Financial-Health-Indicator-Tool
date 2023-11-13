package com.demo.healthservice.controller;

import com.demo.healthservice.domain.BalanceRecord;
import com.demo.healthservice.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @Autowired
    private HealthService healthService;
    @PostMapping("/save")
    public ResponseEntity<String> calculateHealth(@RequestBody BalanceRecord balanceRecord){
        System.out.println(balanceRecord.getMonth());
        BalanceRecord balanceRecordRes = healthService.save(balanceRecord);
        return ResponseEntity.ok("All Good");
    }
}
