package com.Hotel.Hotel.repository;

import com.Hotel.Hotel.model.MenuItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemsRepository extends JpaRepository<MenuItems, Long> {
    List<MenuItems> findByCategoryId(Long categoryId);
}
