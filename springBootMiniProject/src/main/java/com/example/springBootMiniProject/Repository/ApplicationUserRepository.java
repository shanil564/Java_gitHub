package com.example.springBootMiniProject.Repository;


import com.example.springBootMiniProject.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUserName(String userName);
    ApplicationUser findByUserId(Long userId);
    void deleteByUserId(Long userId);
}

