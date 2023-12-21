package com.example.springBootMiniProject.controller;
import com.example.springBootMiniProject.Constants;
import com.example.springBootMiniProject.dto.Response;
import com.example.springBootMiniProject.entity.Role;
import com.example.springBootMiniProject.service.implementation.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(Constants.ROLES)
public class RoleController {
    @Autowired
    RoleService roleService;
    @GetMapping(Constants.PATH)
    public ResponseEntity<?> getRoleByName(@RequestParam(Constants.ROLE_NAME) String roleName) {
        Response response=new Response();
        response.setStatus(true);
        response.setResponse(roleService.getRoleByName(roleName));
        return ResponseEntity.ok(response);
    }
    @PostMapping(Constants.PATH)
    public ResponseEntity<?> saveRole(@RequestBody  Role role) {
        Response response=new Response();
        response.setResponse(roleService.saveRole(role));
        response.setStatus(true);
        response.setMessage(Constants.MSG_ADDED);
        return ResponseEntity.ok(response);
    }
}

