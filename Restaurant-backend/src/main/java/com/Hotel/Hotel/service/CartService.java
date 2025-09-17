package com.Hotel.Hotel.service;

import com.Hotel.Hotel.model.CartItem;
import com.Hotel.Hotel.model.MenuItems;
import com.Hotel.Hotel.repository.CartRepository;
import com.Hotel.Hotel.repository.MenuItemsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final MenuItemsRepository menuRepository;

    public CartService(CartRepository cartRepository, MenuItemsRepository menuRepository) {
        this.cartRepository = cartRepository;
        this.menuRepository = menuRepository;
    }

    // Add or update cart item
    public void addToCart(Long userId, Long menuItemId, int quantity) {
        MenuItems menuItem = menuRepository.findById(menuItemId)
                .orElseThrow(() -> new RuntimeException("Menu item not found"));

        CartItem cartItem = cartRepository.findByUserIdAndMenuItem(userId, menuItem)
                .orElse(new CartItem());

        cartItem.setUserId(userId);
        cartItem.setMenuItem(menuItem);
        cartItem.setQuantity(quantity);

        cartRepository.save(cartItem);
    }

    // Remove item from cart
    public void removeFromCart(Long userId, Long menuItemId) {
        MenuItems menuItem = menuRepository.findById(menuItemId)
                .orElseThrow(() -> new RuntimeException("Menu item not found"));

        cartRepository.findByUserIdAndMenuItem(userId, menuItem)
                .ifPresent(cartRepository::delete);
    }

    // Get all cart items for a user
    public List<CartItem> getCartItems(Long userId) {
        return cartRepository.findByUserId(userId);
    }
}
