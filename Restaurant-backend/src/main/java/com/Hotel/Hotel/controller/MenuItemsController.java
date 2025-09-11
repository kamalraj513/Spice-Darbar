package com.Hotel.Hotel.controller;

import com.Hotel.Hotel.model.MenuItems;
import com.Hotel.Hotel.service.MenuItemsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/MenuItems")
@CrossOrigin(origins = "http://localhost:5173/")
public class MenuItemsController {
    private final MenuItemsService menuItemsService;

    public MenuItemsController(MenuItemsService menuItemsService) {
        this.menuItemsService = menuItemsService;
    }

    @GetMapping
    public List<MenuItems> getAllMenuItems()
    {
        return menuItemsService.getAllProducts();
    }

    @GetMapping("/category/{categoryId}")
    public List<MenuItems> getMenuItemsByCategoryID(@PathVariable Long categoryId)
    {
        return menuItemsService.getMenuItemsByCategoryID(categoryId);
    }
}
