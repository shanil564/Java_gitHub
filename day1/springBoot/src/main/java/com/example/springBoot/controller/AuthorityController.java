package com.example.springBoot.controller;

import com.example.springBoot.model.Authority;
import com.example.springBoot.model.Role;
import com.example.springBoot.service.AuthorityService;
import com.example.springBoot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authorities")
public class AuthorityController {
    @Autowired
    AuthorityService authorityService;

    @PostMapping("/")
    public Authority saveRole(@RequestBody Authority authority) {
        return authorityService.saveAuthority(authority);
    }
}
