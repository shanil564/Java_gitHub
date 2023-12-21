package com.example.springBoot.service;


import com.example.springBoot.exception.DuplicateUserException;
import com.example.springBoot.model.ApplicationUser;
import com.example.springBoot.departmentRepo.ApplicationUserRepository;
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
