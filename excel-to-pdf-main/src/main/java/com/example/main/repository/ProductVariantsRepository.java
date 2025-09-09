package com.example.main.repository;

import com.example.main.model.ProductVariants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductVariantsRepository extends JpaRepository<ProductVariants, Long> {
}

