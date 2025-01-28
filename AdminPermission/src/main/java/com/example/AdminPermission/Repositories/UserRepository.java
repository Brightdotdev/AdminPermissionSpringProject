package com.example.AdminPermission.Repositories;

import com.example.AdminPermission.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

}
