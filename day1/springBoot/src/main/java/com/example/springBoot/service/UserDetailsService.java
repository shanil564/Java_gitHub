package com.example.springBoot.service;



import com.example.springBoot.exception.RecordNotFoundException;
import com.example.springBoot.model.ApplicationUser;
import com.example.springBoot.model.Authority;
import com.example.springBoot.departmentRepo.ApplicationUserRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Slf4j
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    ApplicationUserRepository applicationUserRepository;
    ApplicationUser userFromDatabase=null;

    @Override
    @SneakyThrows
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user=null;
        userFromDatabase = applicationUserRepository.findByUserName(userName);
        if (userFromDatabase!=null){
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            for(Authority authority:userFromDatabase.getRole().getAuthorityList()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthorityName()));
            }
            user=new User(userFromDatabase.getUserName(),userFromDatabase.getPassword(),grantedAuthorities);
        }else{
            throw new RecordNotFoundException("No Such user existing");
        }
        return  user;
    }
}
