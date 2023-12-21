package com.example.demo.controller;


import com.example.demo.Constants;
import com.example.demo.exception.DuplicateUserException;
import com.example.demo.entity.ApplicationUser;
import com.example.demo.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.USER_PATH)
public class ApplicationUserController {
    @Autowired
    ApplicationUserService applicationUserService;
    @GetMapping(Constants.PATH_VARIABLE_ID)
    public ApplicationUser getUser(@PathVariable(Constants.ID) Long userId) {
        return applicationUserService.getUser(userId);
    }
    @PostMapping(Constants.PATH)
    public ApplicationUser saveUser(@RequestBody ApplicationUser applicationUser) throws DuplicateUserException {
        return applicationUserService.saveUser(applicationUser);
    }
}

