package com.example.AdminPermission.Controllers;

import com.example.AdminPermission.Models.Items;
import com.example.AdminPermission.Services.ItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemServices itemService;


    @GetMapping
    public List<Items> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Optional<Items> getItemById(@PathVariable int id) {
        return itemService.getItemById(id);
    }
}