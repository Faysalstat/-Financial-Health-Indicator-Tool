package com.demo.healthservice.serviceImp;

import com.demo.healthservice.domain.BalanceRecord;
import com.demo.healthservice.domain.ResponseBodyDomain;
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
    public ResponseBodyDomain<BalanceRecord> saveRecord(BalanceRecord balanceRecord) {
        BalanceRecord resBalanceRecord = new BalanceRecord();
        ResponseBodyDomain<BalanceRecord> responseBodyDomain = new ResponseBodyDomain();
        try{
            resBalanceRecord = healthRepository.save(balanceRecord);
            responseBodyDomain.setMessage("Successfully Saved");
            responseBodyDomain.setIsSuccess(true);
            responseBodyDomain.setBody(resBalanceRecord);

        }catch (Exception e){
            responseBodyDomain.setMessage("Saving Failed. Error"+ e.getMessage());
            responseBodyDomain.setIsSuccess(false);
            responseBodyDomain.setBody(resBalanceRecord);
        }finally {
            return responseBodyDomain;
        }

    }
}
