package com.example.AdminPermission.Repositories;

import com.example.AdminPermission.Models.Admin;
import com.example.AdminPermission.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Optional<Admin> findByEmail(String email);
}
