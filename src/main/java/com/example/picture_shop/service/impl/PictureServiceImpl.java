package com.example.picture_shop.service.impl;

import com.example.picture_shop.model.Category;
import com.example.picture_shop.model.Picture;
import com.example.picture_shop.repository.IPictureRepository;
import com.example.picture_shop.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements IPictureService {
    @Autowired
    private IPictureRepository iPictureRepository;

    @Override
    public List<Picture> findByCode(String pictureCode) {
        return iPictureRepository.findByPictureCode("%" + pictureCode + "%");
    }

    @Override
    public List<Picture> findByCategory(Category category) {
        return iPictureRepository.findPictureByCategory(category);
    }

    @Override
    public void save(Picture picture) {
        iPictureRepository.save(picture);
    }

    @Override
    public void delete(Long id) {
        iPictureRepository.deleteById(id);
    }

    @Override
    public Picture findById(Long id) {
        return iPictureRepository.findById(id).orElse(null);
    }

    @Override
    public List<Picture> findAll() {
        return iPictureRepository.findAll();
    }
}
