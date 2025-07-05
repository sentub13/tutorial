package com.example.main.repository;

import com.example.main.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagesRepository extends JpaRepository<Images, Integer> {
    List<Images> findByProductId(Integer productId);
    List<Images> findByProductIdAndIsMain(Integer productId, Boolean isMain);
}
