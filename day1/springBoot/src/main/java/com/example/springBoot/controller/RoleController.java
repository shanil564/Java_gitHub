package com.example.springBoot.controller;


import com.example.springBoot.model.Role;
import com.example.springBoot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    RoleService roleService;
    @GetMapping("/")
    public Role getRoleByName(@RequestParam("roleName") String roleName) {
        return roleService.getRoleByName(roleName);
    }
    @PostMapping("/")
    public Role saveRole(@RequestBody  Role role) {
        return roleService.saveRole(role);
    }
}

