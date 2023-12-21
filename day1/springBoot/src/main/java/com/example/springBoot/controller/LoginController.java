package com.example.springBoot.controller;


import com.example.springBoot.exception.InvalidUserException;
import com.example.springBoot.model.AuthenticationRequest;
import com.example.springBoot.model.AuthenticationResponse;
import com.example.springBoot.service.UserDetailsService;
import com.example.springBoot.config.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    JwtUtil jwtUtil;
    @PostMapping("/")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(),authenticationRequest.getPassword()));
        } catch (BadCredentialsException be) {
            log.error("Invalid credentials");
            throw new InvalidUserException("Invalid credentials");

        }
        try {
            final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
            final String jwt = jwtUtil.generateToken(userDetails);
            return ResponseEntity.ok(new AuthenticationResponse(jwt));
        } catch (UsernameNotFoundException unf) {
            throw new InvalidUserException("Username not found");
        }
    }
}

