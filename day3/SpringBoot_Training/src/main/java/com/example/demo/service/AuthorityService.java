package com.example.demo.service;


import com.example.demo.repository.AuthorityRepository;
import com.example.demo.entity.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {
    @Autowired
    AuthorityRepository authorityRepository;
    public Authority saveAuthority(Authority authority) {
        return authorityRepository.save(authority);
    }
}

