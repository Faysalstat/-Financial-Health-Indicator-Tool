package com.demo.healthservice.serviceImp;

import com.demo.healthservice.domain.BalanceRecord;
import com.demo.healthservice.repository.HealthRepository;
import com.demo.healthservice.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HealthServiceImp implements HealthService {

    @Autowired
    private HealthRepository healthRepository;
    @Override
    public List<BalanceRecord> getAll() {
        return healthRepository.findAll();
    }

    @Override
    public BalanceRecord save(BalanceRecord balanceRecord) {
        return healthRepository.save(balanceRecord);
    }
}
