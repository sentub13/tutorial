package com.example.main.controller;

import com.example.main.model.ProductReviews;
import com.example.main.repository.ProductReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-reviews")
public class ProductReviewsController {
    @Autowired
    private ProductReviewsRepository productReviewsRepository;

    @GetMapping
    public List<ProductReviews> getAllProductReviews() {
        return productReviewsRepository.findAll();
    }

    @PostMapping
    public ProductReviews createProductReview(@RequestBody ProductReviews productReview) {
        return productReviewsRepository.save(productReview);
    }

    @GetMapping("/{id}")
    public ProductReviews getProductReviewById(@PathVariable Long id) {
        return productReviewsRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public ProductReviews updateProductReview(@PathVariable Long id, @RequestBody ProductReviews productReview) {
        return productReviewsRepository.save(productReview);
    }

    @DeleteMapping("/{id}")
    public void deleteProductReview(@PathVariable Long id) {
        productReviewsRepository.deleteById(id);
    }
}
