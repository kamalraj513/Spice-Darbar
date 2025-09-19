package com.Hotel.Hotel.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @ManyToOne
    private MenuItems menuItem;

    private int quantity;
    private double price;

    // Address fields
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String pincode;
    private String paymentMode;
}
