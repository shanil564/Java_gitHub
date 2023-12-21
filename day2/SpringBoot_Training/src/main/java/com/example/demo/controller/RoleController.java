package com.example.demo.controller;


import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;
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

