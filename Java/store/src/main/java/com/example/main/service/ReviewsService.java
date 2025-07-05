package com.example.main.service;

import com.example.main.model.Reviews;
import com.example.main.repository.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewsService {
    @Autowired
    private ReviewsRepository reviewsRepository;

    public List<Reviews> getReviewsByProductId(Integer productId) {
        return reviewsRepository.findByProductId(productId);
    }

    public Reviews addReview(Reviews review) {
        return reviewsRepository.save(review);
    }

    public Optional<Reviews> getReviewById(Integer reviewId) {
        return reviewsRepository.findById(reviewId);
    }

    public void deleteReview(Integer reviewId) {
        reviewsRepository.deleteById(reviewId);
    }
}
