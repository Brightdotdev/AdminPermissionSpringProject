package com.example.AdminPermission.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthControllers {


    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        // Spring Security will handle authentication
        return "Login successful!";
    }
}
