package com.example.picture_shop.repository;

import com.example.picture_shop.model.Picture;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PictureRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Picture> findAll() {
        TypedQuery<Picture> strQuery = entityManager.createNamedQuery("findAll", Picture.class);
        return strQuery.getResultList();
    }

    public Picture findById(Long id) {
        return entityManager.find(Picture.class, id);
    }

    public void create(Picture picture) {
        entityManager.persist(picture);
    }

    public void update(Picture product) {
        entityManager.merge(product);
    }


    public void delete(Long id) {
        entityManager.remove(findById(id));
    }
}
