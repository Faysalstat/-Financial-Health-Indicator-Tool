package com.demo.securityservice.repository;

import com.demo.securityservice.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserDetails,Long> {
}
