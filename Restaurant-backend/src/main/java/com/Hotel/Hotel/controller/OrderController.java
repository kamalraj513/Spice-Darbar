package com.Hotel.Hotel.controller;

import com.Hotel.Hotel.model.Order;
import com.Hotel.Hotel.model.Address;
import com.Hotel.Hotel.service.OrderService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{userId}")
    public ResponseEntity<List<Order>> placeOrder(
            @PathVariable Long userId,
            @RequestBody Address address) {
        try {
            List<Order> orders = orderService.placeOrder(userId, address);
            return ResponseEntity.ok(orders);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{userId}")
    public List<Order> getOrders(@PathVariable Long userId) {
        return orderService.getOrdersByUser(userId);
    }
}
