package com.example.AdminPermission.Controllers;


import com.example.AdminPermission.Models.User;
import com.example.AdminPermission.Repositories.UserRepository;
import com.example.AdminPermission.Utils.ApiResponse;
import com.example.AdminPermission.Utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/users")
public class UserController{

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public ApiResponse<User> getUserById(@RequestBody User user, @PathVariable int id){

        User foundUser = userRepository.findById(id).orElse(null);
        if(user == null){
            return ResponseHandler.error(404, "User not found","/user/id");
        }
        return ResponseHandler.success(foundUser,"User not found\",\"/user/id" );
    }
}
