package com.Hotel.Hotel.model;

//import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;
     private String name;

    @OneToMany(mappedBy = "category",
    cascade = CascadeType.ALL,
    fetch = FetchType.LAZY)
    @JsonManagedReference
     private List<MenuItems> menuItems;

}
