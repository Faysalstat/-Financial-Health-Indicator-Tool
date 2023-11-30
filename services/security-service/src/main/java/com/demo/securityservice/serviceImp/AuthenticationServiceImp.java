package com.demo.securityservice.serviceImp;

import com.demo.securityservice.entity.UserDetails;
import com.demo.securityservice.repository.UserRepository;
import com.demo.securityservice.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class AuthenticationServiceImp implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Override
    public String saveUser(UserDetails userDetails) {
        try {
            userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));
            UserDetails response = userRepository.save(userDetails);
            return "User successfully saved";
        } catch (Exception e) {
            return "Operation Failed. Error: " + e.getMessage();
        }
    }

    @Override
    public List<UserDetails> getAllUser() {
        List<UserDetails> response = new ArrayList();
        try {
            response = userRepository.findAll();
            return response;
        } catch (Exception e) {
            return response;
        }
    }

    @Override
    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }
    @Override
    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
}
