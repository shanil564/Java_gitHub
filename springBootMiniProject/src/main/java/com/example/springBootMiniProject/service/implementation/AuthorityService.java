package com.example.springBootMiniProject.service.implementation;


import com.example.springBootMiniProject.Repository.AuthorityRepository;
import com.example.springBootMiniProject.entity.Authority;
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

