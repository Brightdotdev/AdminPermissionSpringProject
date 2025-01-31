package com.example.AdminPermission.Models;
import com.example.AdminPermission.Utils.Utils;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private int id;

    public Admin(int id, String name, String email, String password, String phoneNumber,
                 String department
                 ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.department = department;

    }

    @Column(nullable = false) // Name is required
    private String name;

    @Column(unique = true, nullable = false) // Email must be unique and required
    private String email;



    @Column(name = "adminBlacklist") // Email must be unique and required
    private List<String> adminBlackList;


    @Column(unique = true, nullable = false) // Email must be unique and required
    private String adminToken = Utils.generateAdminToken();

    public Admin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAdminToken() {
        return adminToken;
    }

    public void setAdminToken(String adminToken) {
        this.adminToken = adminToken;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    @Column(nullable = false) // Password is required
    private String password;

    @Column(nullable = false) // Role is required
    private String role = "ROLE_ADMIN"; // Default role is "ADMIN"

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
