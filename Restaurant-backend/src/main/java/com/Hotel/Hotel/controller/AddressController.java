package com.Hotel.Hotel.controller;

import com.Hotel.Hotel.model.Address;
import com.Hotel.Hotel.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/address")
@CrossOrigin(origins = "http://localhost:5173") // React dev server
public class AddressController {

    @Autowired
    private AddressService service;

    // Save address for a user
    @PostMapping("/{userId}")
    public Address saveAddress(@PathVariable Long userId, @RequestBody Address address) {
        return service.saveAddress(userId, address);
    }

    // Get all addresses of a user
    @GetMapping("/{userId}")
    public List<Address> getAddressesByUser(@PathVariable Long userId) {
        return service.getAddressesByUser(userId);
    }
}

