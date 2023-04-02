package com.example.picture_shop.service.impl;

import com.example.picture_shop.model.Category;
import com.example.picture_shop.repository.ICategoryRepository;
import com.example.picture_shop.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public void save(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        iCategoryRepository.deleteById(id);
    }

    @Override
    public Category findById(Long id) {
        return iCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }
}
