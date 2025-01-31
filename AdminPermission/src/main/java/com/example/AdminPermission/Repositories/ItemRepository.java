package com.example.AdminPermission.Repositories;

import com.example.AdminPermission.Models.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Items, Integer> {
}
