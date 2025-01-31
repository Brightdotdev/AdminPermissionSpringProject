package com.example.AdminPermission.Services;

import com.example.AdminPermission.Models.Admin;
import com.example.AdminPermission.Repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;

@Service
public class AdminServices{

    @Autowired
    private final AdminRepository adminRepository;

    private final PasswordEncoder passwordEncoder;

    public AdminServices(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Register a new admin
    public boolean registerAdmin(Admin admin) {
        if (adminRepository.findByEmail(admin.getEmail()).isPresent()) {
            throw new RuntimeException("admin with email already exists!");
        }
        String encodedPassword = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(encodedPassword);
        adminRepository.save(admin);
        return true;
    }


    public Optional<Admin> getAdminById(int id) {
        return adminRepository.findById(id);
    }


    // Delete a admin by ID
    public void deleteAdmin(int id) {
        adminRepository.deleteById(id);
    }

    public Optional<Admin> getAdminByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

}
