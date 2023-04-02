package com.example.picture_shop.repository;

import com.example.picture_shop.model.Category;
import com.example.picture_shop.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPictureRepository extends JpaRepository<Picture, Long> {
    @Query(value = "select p from Picture p join Category c on c.id = p.category.id where p.category.name = c.name")
    List<Picture> findPictureByCategory(@Param("category")Category category);

    @Query(value = "select p from Picture p where p.pictureCode like :pictureCode")
    List<Picture> findByPictureCode(@Param("pictureCode") String pictureCode);
}
