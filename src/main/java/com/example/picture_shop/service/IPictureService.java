package com.example.picture_shop.service;

import com.example.picture_shop.model.Category;
import com.example.picture_shop.model.Picture;
import com.example.picture_shop.service.core.ICoreService;

import java.util.List;

public interface IPictureService extends ICoreService<Picture> {
    List<Picture> findByCode(String pictureCode);
    List<Picture> findByCategory(Category category);
}
