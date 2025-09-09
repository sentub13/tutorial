package com.example.main.service;

import com.example.main.model.ProductReviews;
import com.example.main.repository.ProductReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductReviewsService {
    @Autowired
    private ProductReviewsRepository productReviewsRepository;

    public List<ProductReviews> getAllProductReviews() {
        return productReviewsRepository.findAll();
    }

    public ProductReviews createProductReview(ProductReviews productReview) {
        return productReviewsRepository.save(productReview);
    }

    public Optional<ProductReviews> getProductReviewById(Long id) {
        return productReviewsRepository.findById(id);
    }

    public ProductReviews updateProductReview(Long id, ProductReviews productReview) {
        return productReviewsRepository.save(productReview);
    }

    public void deleteProductReview(Long id) {
        productReviewsRepository.deleteById(id);
    }
}

