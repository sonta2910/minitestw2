package com.example.picture_shop.model;

import javax.persistence.*;

@Entity
@Table
//annotation đánh dấu đây là 1 thực thể trong dự án
//kết nối ORM để tạo bảng => khóa chính
@NamedQuery(name = "findAll", query = "SELECT p FROM Picture AS p")
//annotation dùng để tạo câu query và đặt tên cho nó, nhằm tái sử dụng nhiều lần
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pictureCode;
    private Double width;
    private Double height;
    private String material;
    private String description;
    private Double price;
    @ManyToOne
    private Category category;

    public Picture(Long id, String pictureCode, Double width, Double height, String material, String description, Double price, Category category) {
        this.id = id;
        this.pictureCode = pictureCode;
        this.width = width;
        this.height = height;
        this.material = material;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Picture() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPictureCode() {
        return pictureCode;
    }

    public void setPictureCode(String pictureCode) {
        this.pictureCode = pictureCode;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
