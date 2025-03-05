package com.example.AdminPermission.Models;


import jakarta.persistence.*;


@Entity
@Table(name = "userBlockList")
public class UserBlackList {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(nullable = false, unique = true)
    private int userId;
    private String userEmail;
    private  int adminId;
    private String adminEmail;

    public UserBlackList() {
    }

    public UserBlackList(int userId, String userEmail, int adminId, String adminEmail) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.adminId = adminId;
        this.adminEmail = adminEmail;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }
}
