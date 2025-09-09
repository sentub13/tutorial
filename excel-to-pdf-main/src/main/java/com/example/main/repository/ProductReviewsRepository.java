package com.example.main.repository;

import com.example.main.model.ProductReviews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReviewsRepository extends JpaRepository<ProductReviews, Long> {
}

