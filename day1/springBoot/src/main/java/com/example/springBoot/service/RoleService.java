package com.example.springBoot.service;


import com.example.springBoot.model.Role;
import com.example.springBoot.departmentRepo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;
    public Role getRoleByName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }
}
