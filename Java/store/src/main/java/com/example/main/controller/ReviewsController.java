package com.example.main.controller;

import com.example.main.model.Reviews;
import com.example.main.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class ReviewsController {
    @Autowired
    private ReviewsService reviewsService;

    @GetMapping("/product/{productId}")
    public List<Reviews> getReviewsByProduct(@PathVariable Integer productId) {
        return reviewsService.getReviewsByProductId(productId);
    }

    @PostMapping
    public Reviews addReview(@RequestBody Reviews review) {
        return reviewsService.addReview(review);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Reviews> getReviewById(@PathVariable Integer reviewId) {
        Optional<Reviews> review = reviewsService.getReviewById(reviewId);
        return review.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Integer reviewId) {
        reviewsService.deleteReview(reviewId);
        return ResponseEntity.noContent().build();
    }
}
