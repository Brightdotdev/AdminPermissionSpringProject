package com.example.AdminPermission.Models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private int id;

    @Column(nullable = false) // Name is required
    private String name;




    @Column(nullable = false) // Name is required
    private boolean isBlocked = false;


    @Column(unique = true, nullable = false) // Email must be unique and required
    private String email;

    @Column(nullable = false) // Password is required
    private String password;

    @Column(nullable = false) // Role is required
    private String role = "ROLE_USER"; // Default role is "USER"

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

    public User(String name, String email,boolean isBlocked, String password, String phoneNumber,
                String profilePictureUrl, String address) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.profilePictureUrl = profilePictureUrl;
        this.address = address;
        this.isBlocked = isBlocked;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
