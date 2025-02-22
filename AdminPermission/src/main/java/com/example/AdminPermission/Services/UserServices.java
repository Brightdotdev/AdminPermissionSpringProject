package com.example.AdminPermission.Services;

import com.example.AdminPermission.Models.User;
import com.example.AdminPermission.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;

@Service
public class UserServices{

    @Autowired
    public UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServices(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Register a new user
    public boolean registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Username already exists!");
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return true;
    }






    public Optional<User> getUserById(int id) {return userRepository.findById(id);}


    // Delete a user by ID
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public Optional<User> getUserByUsername(String email) {
        return userRepository.findByEmail(email);
    }

}
