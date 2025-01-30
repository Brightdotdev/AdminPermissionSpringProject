package com.example.AdminPermission.Models;
import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "admins")
public class Admin {

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
    private String role = "ADMIN"; // Default role is "ADMIN"

    @Column(nullable = false) // Contact number is required
    private String phoneNumber;

    @Column(nullable = true) // Optional profile picture
    private String profilePictureUrl;

    @Column(nullable = true) // Optional department
    private String department;

    @Column(nullable = false, updatable = false) // Timestamp of creation
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false) // Tracks when the admin was last updated
    private LocalDateTime updatedAt = LocalDateTime.now();
}
