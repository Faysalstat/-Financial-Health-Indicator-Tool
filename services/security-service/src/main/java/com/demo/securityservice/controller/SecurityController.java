package com.demo.securityservice.controller;

import com.demo.securityservice.dto.AuthRequest;
import com.demo.securityservice.entity.UserDetails;
import com.demo.securityservice.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class SecurityController {
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/user/getall")
    public ResponseEntity<List<UserDetails>> getAllUserDetails(){
        List<UserDetails> userList = authenticationService.getAllUser();
        return ResponseEntity.ok(userList);
    }

    @PostMapping("/user/save")
    public ResponseEntity<String> saveUser(@RequestBody UserDetails userDetails){
        String response = authenticationService.saveUser(userDetails);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return authenticationService.generateToken(authRequest.getUsername());
        } else {
            throw new RuntimeException("invalid access");
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        authenticationService.validateToken(token);
        return "Token is valid";
    }
}
