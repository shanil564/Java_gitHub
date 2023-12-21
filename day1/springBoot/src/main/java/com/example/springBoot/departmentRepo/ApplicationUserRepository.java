package com.example.springBoot.departmentRepo;


import com.example.springBoot.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUserName(String userName);
    ApplicationUser findByUserId(Long userId);
}

