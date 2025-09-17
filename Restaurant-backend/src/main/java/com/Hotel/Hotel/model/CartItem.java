package com.Hotel.Hotel.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "menu_item_id")
    private MenuItems menuItem;
}
