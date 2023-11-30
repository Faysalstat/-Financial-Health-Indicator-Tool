package com.demo.securityservice.service;

import com.demo.securityservice.entity.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthenticationService {
    String saveUser(UserDetails userDetails);
    List<UserDetails> getAllUser();
    String generateToken(String username);
    void validateToken(String token);
}
