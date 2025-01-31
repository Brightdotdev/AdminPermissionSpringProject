package com.example.AdminPermission.Controllers;

import com.example.AdminPermission.RequestBody.AuthRequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthControllers {


    @PostMapping("/login")
    public String login(@RequestBody AuthRequestBody.LoginRequest loginRequest) {
        return "Login successful!";
    }

}
