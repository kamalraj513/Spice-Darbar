package com.Hotel.Hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.Hotel.Hotel.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByUserId(Long userId);  // custom query
}

