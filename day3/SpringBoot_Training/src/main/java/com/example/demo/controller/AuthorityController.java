package com.example.demo.controller;

import com.example.demo.Constants;
import com.example.demo.entity.Authority;
import com.example.demo.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.AUTHORITIES_PATH)
public class AuthorityController {
    @Autowired
    AuthorityService authorityService;

    @PostMapping(Constants.PATH)
    public Authority saveRole(@RequestBody Authority authority) {
        return authorityService.saveAuthority(authority);
    }
}
