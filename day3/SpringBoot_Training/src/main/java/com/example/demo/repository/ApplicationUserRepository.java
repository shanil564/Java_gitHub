package com.example.demo.repository;


import com.example.demo.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUserName(String userName);
    ApplicationUser findByUserId(Long userId);
}

