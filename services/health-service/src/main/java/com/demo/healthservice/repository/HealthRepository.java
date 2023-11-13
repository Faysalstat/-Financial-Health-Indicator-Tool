package com.demo.healthservice.repository;

import com.demo.healthservice.domain.BalanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthRepository extends JpaRepository<BalanceRecord, Long> {
}
