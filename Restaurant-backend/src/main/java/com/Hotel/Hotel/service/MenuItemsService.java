package com.Hotel.Hotel.service;

import com.Hotel.Hotel.model.MenuItems;
import com.Hotel.Hotel.repository.MenuItemsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemsService
{
    private final MenuItemsRepository menuItemsRepository;

    public MenuItemsService(MenuItemsRepository menuItemsRepository) {
        this.menuItemsRepository = menuItemsRepository;
    }

    public List<MenuItems> getAllProducts() {
        return menuItemsRepository.findAll();
    }

    public List<MenuItems> getMenuItemsByCategoryID(Long categoryId) {
        return menuItemsRepository.findByCategoryId(categoryId);
    }
}
