package com.example.springBootMiniProject.service.implementation;


import com.example.springBootMiniProject.Repository.RoleRepository;
import com.example.springBootMiniProject.entity.Role;
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
