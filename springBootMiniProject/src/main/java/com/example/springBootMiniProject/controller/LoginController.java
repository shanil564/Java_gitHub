package com.example.springBootMiniProject.controller;
import com.example.springBootMiniProject.Constants;
import com.example.springBootMiniProject.config.JwtUtil;
import com.example.springBootMiniProject.exception.InvalidUserException;
import com.example.springBootMiniProject.dto.AuthenticationRequest;
import com.example.springBootMiniProject.dto.AuthenticationResponse;
import com.example.springBootMiniProject.service.implementation.UserDetailsService;
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
@RequestMapping(Constants.LOGIN)
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    JwtUtil jwtUtil;
    @PostMapping(Constants.PATH)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(),authenticationRequest.getPassword()));
        } catch (BadCredentialsException be) {
           // log.error("Invalid credentials");
            throw new InvalidUserException(Constants.INVALID_USER_EXCEPTION_MSG);
        }
        try {
            final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
            final String jwt = jwtUtil.generateToken(userDetails);
            return ResponseEntity.ok(new AuthenticationResponse(jwt));
        } catch (UsernameNotFoundException unf) {
            throw new InvalidUserException(Constants.INVALID_USER_USERNAME_EXCEPTION_MSG);
        }
    }
}

