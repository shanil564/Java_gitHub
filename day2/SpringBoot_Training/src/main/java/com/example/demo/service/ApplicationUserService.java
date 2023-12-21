package com.example.demo.service;


import com.example.demo.repository.ApplicationUserRepository;
import com.example.demo.exception.DuplicateUserException;
import com.example.demo.entity.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService {
    @Autowired
    ApplicationUserRepository applicationUserRepository;
    public ApplicationUser getUser(Long userId) {
        return applicationUserRepository.findByUserId(userId);
    }

    public ApplicationUser saveUser(ApplicationUser applicationUser) throws DuplicateUserException{
        if(applicationUserRepository.findByUserName(applicationUser.getUserName())!=null) {
            throw new DuplicateUserException("User name already exists");
        }
        return applicationUserRepository.save(applicationUser);
    }
}
