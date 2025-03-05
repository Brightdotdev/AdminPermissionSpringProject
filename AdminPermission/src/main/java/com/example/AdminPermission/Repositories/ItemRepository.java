package com.example.AdminPermission.Repositories;

import com.example.AdminPermission.Models.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Items, Integer> {


}
