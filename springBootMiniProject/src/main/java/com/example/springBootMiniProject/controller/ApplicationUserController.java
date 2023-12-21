package com.example.springBootMiniProject.controller;
import com.example.springBootMiniProject.Constants;
import com.example.springBootMiniProject.dto.Response;
import com.example.springBootMiniProject.exception.DuplicateUserException;
import com.example.springBootMiniProject.entity.ApplicationUser;
import com.example.springBootMiniProject.service.implementation.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.USER_PATH)
public class ApplicationUserController {
    @Autowired
    ApplicationUserService applicationUserService;
    @GetMapping(Constants.PATH_VARIABLE_ID)
    public ResponseEntity<?> getUser(@PathVariable(Constants.ID) Long userId) {
        ApplicationUser applicationUser=applicationUserService.getUser(userId);
        Response response=new Response();
        response.setStatus(true);
        response.setResponse(applicationUser);
        return ResponseEntity.ok(response);
    }
    @PostMapping(Constants.PATH)
    public ResponseEntity<?> saveUser(@RequestBody ApplicationUser applicationUserDto) throws DuplicateUserException {
        ApplicationUser applicationUser= applicationUserService.saveUser(applicationUserDto);
        Response response=new Response();
        response.setStatus(true);
        response.setMessage(Constants.MSG_ADDED);
        response.setResponse(applicationUser);
        return ResponseEntity.ok(response);
    }
    @PreAuthorize(Constants.HAS_AUTHORITY_WRITE)
    @PutMapping(Constants.PATH)
    public ResponseEntity<?> updateUser(@RequestBody ApplicationUser applicationUser) throws DuplicateUserException {
        return applicationUserService.updateUser(applicationUser);
    }
    @PreAuthorize(Constants.HAS_AUTHORITY_DELETE)
    @DeleteMapping(Constants.PATH)
    public ResponseEntity<?> deleteUser(@RequestBody ApplicationUser applicationUser){
        applicationUserService.deleteUser(applicationUser);
        Response response=new Response();
        response.setMessage(Constants.MSG_DELETED);
        response.setStatus(true);
        return ResponseEntity.ok(response);
    }
    @GetMapping(Constants.PATH)
    public ResponseEntity<?> getAllUser(){
        Response response=new Response();
        response.setList(applicationUserService.getAllUser());
        response.setStatus(true);
        return ResponseEntity.ok(response);
    }

}

