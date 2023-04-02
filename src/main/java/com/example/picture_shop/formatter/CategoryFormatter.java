package com.example.picture_shop.formatter;

import com.example.picture_shop.model.Category;
import com.example.picture_shop.service.ICategoryService;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CategoryFormatter implements Formatter<Category> {
    private ICategoryService iCategoryService;

    public CategoryFormatter(ICategoryService iCategoryService) {
        this.iCategoryService = iCategoryService;
    }

    @Override
    public Category parse(String text, Locale locale) {
        return iCategoryService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Category object, Locale locale) {
        return null;
    }
}
