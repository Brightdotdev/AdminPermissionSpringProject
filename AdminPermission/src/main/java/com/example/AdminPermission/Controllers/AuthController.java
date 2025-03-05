package com.example.AdminPermission.Controllers;

import com.example.AdminPermission.Models.Admin;
import com.example.AdminPermission.Models.User;
import com.example.AdminPermission.Repositories.AdminRepository;
import com.example.AdminPermission.Repositories.UserRepository;
import com.example.AdminPermission.RequestBody.AuthRequestBody;
import com.example.AdminPermission.Utils.ApiResponse;
import com.example.AdminPermission.Utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/login")
    public String login(@RequestBody AuthRequestBody.LoginRequest loginRequest) {
        return "Login successful!";
    }

    @PostMapping("/signUp")
    public ApiResponse<User> signUserUp(@RequestBody User user) {
        if(userRepository.existsByEmail(user.getEmail())){
            return ResponseHandler.error(403, "Username already exists","/signup");
        }
        User userCreated = userRepository.save(user);
        return ResponseHandler.success(userCreated,"/signUp");
    }

    @PostMapping("/signUp/admin")
    public ApiResponse<Admin> signAdminUp(@RequestBody Admin admin) {

         if(adminRepository.existsByEmail(admin.getEmail())){
             return ResponseHandler.error(403, "Username already exists","/signup/admin");
         }
         Admin adminCreated = adminRepository.save(admin);
         return ResponseHandler.success(adminCreated,"/signup/admin");
    }



}
