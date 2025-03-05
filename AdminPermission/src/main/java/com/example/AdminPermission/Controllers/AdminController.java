package com.example.AdminPermission.Controllers;



import com.example.AdminPermission.Models.Admin;
import com.example.AdminPermission.Repositories.AdminRepository;
import com.example.AdminPermission.Utils.ApiResponse;
import com.example.AdminPermission.Utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/{id}")
    public ApiResponse<Admin> getAdminById(@RequestBody Admin admin, @PathVariable int id){

        Admin foundAdmin = adminRepository.findById(id).orElse(null);
        if(admin == null){
            return ResponseHandler.error(404, "Admin not found","/admin/id");
        }
        return ResponseHandler.success(foundAdmin,"Admin not found\",\"/admin/id" );
    }
}
