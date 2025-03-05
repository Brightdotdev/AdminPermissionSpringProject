package com.example.AdminPermission.Controllers;

import com.example.AdminPermission.Models.Items;
import com.example.AdminPermission.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemRepository itemrepository;
}