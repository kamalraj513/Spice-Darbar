package com.Hotel.Hotel.controller;

import com.Hotel.Hotel.model.CartItem;
import com.Hotel.Hotel.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:5173")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // Add or update cart item
    @PostMapping("/{userId}/add")
    public String addToCart(@PathVariable Long userId, @RequestBody CartItemRequest request) {
        cartService.addToCart(userId, request.getMenuItemId(), request.getQuantity());
        return "Item added/updated in cart";
    }

    // Remove cart item
    @DeleteMapping("/{userId}/remove/{menuItemId}")
    public String removeFromCart(@PathVariable Long userId, @PathVariable Long menuItemId) {
        cartService.removeFromCart(userId, menuItemId);
        return "Item removed from cart";
    }

    // Get all cart items for a user
    @GetMapping("/{userId}")
    public List<CartItem> getCart(@PathVariable Long userId) {
        return cartService.getCartItems(userId);
    }

    // Request DTO
    public static class CartItemRequest {
        private Long menuItemId;
        private int quantity;

        public Long getMenuItemId() { return menuItemId; }
        public void setMenuItemId(Long menuItemId) { this.menuItemId = menuItemId; }
        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { this.quantity = quantity; }
    }
}
