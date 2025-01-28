package com.example.AdminPermission.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private int id;

    @Column(nullable = false) // Name is required
    private String name;

    @Column(unique = true, nullable = false) // Email must be unique and required
    private String email;

    @Column(nullable = false) // Password is required
    private String password;

    @Column(nullable = false) // Role is required
    private String role = "USER"; // Default role is "USER"

    @Column(nullable = false) // Contact number is required
    private String phoneNumber;

    @Column(nullable = true) // Optional profile picture
    private String profilePictureUrl;

    @Column(nullable = true) // Optional address field
    private String address;

    @Column(nullable = false, updatable = false) // Timestamp of creation
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false) // Tracks when the user was last updated
    private LocalDateTime updatedAt = LocalDateTime.now();
}
