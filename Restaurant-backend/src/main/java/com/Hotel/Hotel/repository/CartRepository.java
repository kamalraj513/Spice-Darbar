package com.Hotel.Hotel.repository;

import com.Hotel.Hotel.model.CartItem;
import com.Hotel.Hotel.model.MenuItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUserId(Long userId);
    Optional<CartItem> findByUserIdAndMenuItem(Long userId, MenuItems menuItem);
}
