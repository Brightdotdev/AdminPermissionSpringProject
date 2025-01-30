package com.example.AdminPermission.SecurityDetails;

import com.example.AdminPermission.Models.User;
import com.example.AdminPermission.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UsersSecurityDetailsServices implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("the email of " + email + " wasn't found o"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail()) // Use email as the username
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
}
