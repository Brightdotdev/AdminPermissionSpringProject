package com.example.AdminPermission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class
AdminPermissionApplication {

	@GetMapping("/home")
	public String getHome(){
		return "Bomboclattt";
	}

	public static void main(String[] args) {
		SpringApplication.run(AdminPermissionApplication.class, args);}

}
