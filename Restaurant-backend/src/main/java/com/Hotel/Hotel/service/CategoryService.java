package com.Hotel.Hotel.service;

import com.Hotel.Hotel.model.Category;
import com.Hotel.Hotel.repository.CategoriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoriesRepository categoriesRepository;

    public CategoryService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public  List<Category> getAllCategories() {
        return categoriesRepository.findAll();
    }
}
