package com.example.springBoot.controller;


import com.example.springBoot.exception.DuplicateUserException;
import com.example.springBoot.service.ApplicationUserService;
import com.example.springBoot.model.ApplicationUser;
import com.example.springBoot.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class ApplicationUserController {
    @Autowired
    ApplicationUserService applicationUserService;
    @GetMapping("/{id}")
    public ApplicationUser getUser(@PathVariable("id") Long userId) {
        return applicationUserService.getUser(userId);
    }
    @PostMapping("/")
    public ApplicationUser saveUser(@RequestBody ApplicationUser applicationUser) throws DuplicateUserException {
        return applicationUserService.saveUser(applicationUser);
    }
}

