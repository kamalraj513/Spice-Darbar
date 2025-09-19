package com.Hotel.Hotel.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address1;
    private String address2;
    private String city;
    private String state;
    private String pincode;
    private String paymentMode;

    @ManyToOne
    @JoinColumn(name = "user_id")  // foreign key in address table
    private User user;
}

