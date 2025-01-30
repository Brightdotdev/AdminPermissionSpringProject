package com.example.AdminPermission.Controllers;


import com.example.AdminPermission.Models.User;
import com.example.AdminPermission.Services.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController{
    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping({"/registerUser"})
    public ResponseEntity<String> registerUser(@RequestBody User user, BindingResult result){
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid user data");
        }
        try {
            userServices.registerUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
