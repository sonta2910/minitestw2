package com.example.picture_shop.service.core;

import java.util.List;

public interface ICoreService <E>{
    void save(E e);
    void delete(Long id);
    E findById(Long id);
    List<E> findAll();
}
