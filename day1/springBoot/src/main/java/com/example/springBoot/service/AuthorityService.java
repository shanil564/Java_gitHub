package com.example.springBoot.service;


import com.example.springBoot.model.Authority;
import com.example.springBoot.model.Role;
import com.example.springBoot.departmentRepo.AuthorityRepository;
import com.example.springBoot.departmentRepo.RoleRepository;
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

