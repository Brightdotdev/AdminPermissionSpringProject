package com.example.AdminPermission.Services;

import com.example.AdminPermission.Models.Items;
import com.example.AdminPermission.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServices {

    @Autowired
    private ItemRepository itemRepository;

    public List<Items> getAllItems() {
        return itemRepository.findAll();
    }

    public Optional<Items> getItemById(int id) {
        return itemRepository.findById(id);
    }
}