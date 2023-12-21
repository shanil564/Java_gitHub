package com.example.demo.controller;


import com.example.demo.exception.DuplicateUserException;
import com.example.demo.entity.ApplicationUser;
import com.example.demo.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

