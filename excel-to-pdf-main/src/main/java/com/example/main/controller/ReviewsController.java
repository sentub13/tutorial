package com.example.main.controller;

import com.example.main.model.Reviews;
import com.example.main.repository.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {
    @Autowired
    private ReviewsRepository reviewsRepository;

    @GetMapping
    public List<Reviews> getAllReviews() {
        return reviewsRepository.findAll();
    }

    @PostMapping
    public Reviews createReview(@RequestBody Reviews review) {
        return reviewsRepository.save(review);
    }

    @GetMapping("/{id}")
    public Reviews getReviewById(@PathVariable Long id) {
        return reviewsRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Reviews updateReview(@PathVariable Long id, @RequestBody Reviews review) {
        return reviewsRepository.save(review);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewsRepository.deleteById(id);
    }
}
