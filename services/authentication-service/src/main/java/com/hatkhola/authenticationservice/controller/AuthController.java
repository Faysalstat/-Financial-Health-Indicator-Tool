package com.hatkhola.authenticationservice.controller;

import com.hatkhola.authenticationservice.model.AthenticationResponse;
import com.hatkhola.authenticationservice.model.AuthenticationRequest;
import com.hatkhola.authenticationservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
       try {
           authenticationManager.authenticate(
                   new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(),authenticationRequest.getPassword())
           );
       }catch (BadCredentialsException e){
           throw new Exception("Bad Credentials!",e);
       }
       final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
       final String token = jwtUtil.generateToken(userDetails);
       return ResponseEntity.ok(new AthenticationResponse(token));
    }

}
