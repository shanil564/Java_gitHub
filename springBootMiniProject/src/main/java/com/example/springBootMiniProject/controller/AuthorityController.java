package com.example.springBootMiniProject.controller;
import com.example.springBootMiniProject.Constants;
import com.example.springBootMiniProject.dto.Response;
import com.example.springBootMiniProject.entity.Authority;
import com.example.springBootMiniProject.service.implementation.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> saveRole(@RequestBody Authority authority) {
        Response response=new Response();
        response.setResponse(authorityService.saveAuthority(authority));
        response.setStatus(true);
        response.setMessage(Constants.MSG_ADDED);
        return ResponseEntity.ok(response);
    }
}
