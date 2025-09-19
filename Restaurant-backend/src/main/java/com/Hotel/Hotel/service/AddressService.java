package com.Hotel.Hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.Hotel.Hotel.repository.AddressRepository;
import com.Hotel.Hotel.repository.UserRepository;
import com.Hotel.Hotel.model.Address;
import com.Hotel.Hotel.model.User;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repo;

    @Autowired
    private UserRepository userRepo;

    public Address saveAddress(Long userId, Address address) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        address.setUser(user);   // associate with user
        return repo.save(address);
    }

    public List<Address> getAddressesByUser(Long userId) {
        return repo.findByUserId(userId);
    }
}

