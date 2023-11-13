package com.demo.healthservice.service;

import com.demo.healthservice.domain.BalanceRecord;
import com.demo.healthservice.domain.ResponseBodyDomain;
import com.demo.healthservice.repository.HealthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface HealthService {

    List<BalanceRecord> getAll();

    ResponseBodyDomain<BalanceRecord> saveRecord(BalanceRecord balanceRecord);
}
