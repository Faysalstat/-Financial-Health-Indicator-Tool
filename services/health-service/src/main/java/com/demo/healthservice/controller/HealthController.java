package com.demo.healthservice.controller;

import com.demo.healthservice.domain.BalanceRecord;
import com.demo.healthservice.domain.ResponseBodyDomain;
import com.demo.healthservice.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/health/api")
@CrossOrigin(origins = "http://localhost:4200")
public class HealthController {

    @Autowired
    private HealthService healthService;
    @PostMapping("/save")
    public ResponseEntity<ResponseBodyDomain<BalanceRecord>> calculateHealth(@RequestBody BalanceRecord balanceRecord){
        System.out.println(balanceRecord.getMonth());
        ResponseBodyDomain<BalanceRecord> balanceRecordRes = healthService.saveRecord(balanceRecord);
        return ResponseEntity.ok(balanceRecordRes);
    }

    @GetMapping("/getall")
    public ResponseEntity<String> getAll(){
        return ResponseEntity.ok("OK");
    }
}
