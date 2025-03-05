package com.example.AdminPermission.Services;

import com.example.AdminPermission.Models.Admin;
import com.example.AdminPermission.Models.User;
import com.example.AdminPermission.Repositories.AdminRepository;
import com.example.AdminPermission.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class GlobalUserServices implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElse(null);

        
        if(user != null){
        return new UserGlobalDetails(user);
        }
            Admin admin = adminRepository.findByEmail(email).orElseThrow(
                    () -> new UsernameNotFoundException("Omo not an admin or a user mtcheewww"));
                    return new UserGlobalDetails(admin);

    }
}
