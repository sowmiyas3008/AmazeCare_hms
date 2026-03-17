package com.hexaware.hms.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.hexaware.hms.entity.User;
import com.hexaware.hms.dao.IUserDAO;
import com.hexaware.hms.exception.UserNotFoundException;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    IUserDAO repo;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        User user = repo.findByEmail(email)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found"));

        return new CustomUserDetails(user);
    }
}