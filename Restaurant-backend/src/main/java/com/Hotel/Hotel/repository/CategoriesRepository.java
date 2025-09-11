package com.Hotel.Hotel.repository;

import com.Hotel.Hotel.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriesRepository extends JpaRepository<Category,Long> {
    Optional<Category> findByName(String name);
}
