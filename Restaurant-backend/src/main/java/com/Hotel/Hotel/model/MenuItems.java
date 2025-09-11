package com.Hotel.Hotel.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;

@Entity
@Data
public class MenuItems
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String imgURL;
    private double price;

    @ManyToOne()
    @JoinColumn(name = "category_id", nullable = false)
    @JsonIgnoreProperties("menuItems")
    private Category category;

}
