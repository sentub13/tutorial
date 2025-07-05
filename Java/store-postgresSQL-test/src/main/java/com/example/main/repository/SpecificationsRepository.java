package com.example.main.repository;

import com.example.main.model.Specifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecificationsRepository extends JpaRepository<Specifications, Integer> {
    List<Specifications> findByProductId(Integer productId);
}
