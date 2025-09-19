package com.Hotel.Hotel.service;

import com.Hotel.Hotel.model.CartItem;
import com.Hotel.Hotel.model.Order;
import com.Hotel.Hotel.model.MenuItems;
import com.Hotel.Hotel.model.User;
import com.Hotel.Hotel.model.Address;
import com.Hotel.Hotel.repository.CartRepository;
import com.Hotel.Hotel.repository.OrderRepository;
import com.Hotel.Hotel.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Order> placeOrder(Long userId, Address address) {
        List<CartItem> cartItems = cartRepository.findByUserId(userId);
        if (cartItems.isEmpty()) throw new RuntimeException("Cart is empty!");

        User user = userRepository.findById(userId).orElseThrow();

        List<Order> orders = cartItems.stream().map(cart -> {
            Order order = new Order();
            order.setUserId(userId);
            order.setMenuItem(cart.getMenuItem());
            order.setQuantity(cart.getQuantity());
            order.setPrice(cart.getMenuItem().getPrice());

            // set address
            order.setAddress1(address.getAddress1());
            order.setAddress2(address.getAddress2());
            order.setCity(address.getCity());
            order.setState(address.getState());
            order.setPincode(address.getPincode());
            order.setPaymentMode(address.getPaymentMode());
            return order;
        }).toList();

        List<Order> savedOrders = orderRepository.saveAll(orders);

        // Clear cart
        cartRepository.deleteAll(cartItems);

        return savedOrders;
    }

    public List<Order> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
