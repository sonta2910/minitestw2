package com.example.picture_shop.repository;

import com.example.picture_shop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Long> {
}
