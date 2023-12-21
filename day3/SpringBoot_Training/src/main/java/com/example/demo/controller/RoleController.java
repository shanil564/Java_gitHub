package com.example.demo.controller;


import com.example.demo.Constants;
import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.ROLES)
public class RoleController {
    @Autowired
    RoleService roleService;
    @GetMapping(Constants.PATH)
    public Role getRoleByName(@RequestParam(Constants.ROLE_NAME) String roleName) {
        return roleService.getRoleByName(roleName);
    }
    @PostMapping(Constants.PATH)
    public Role saveRole(@RequestBody  Role role) {
        return roleService.saveRole(role);
    }
}

