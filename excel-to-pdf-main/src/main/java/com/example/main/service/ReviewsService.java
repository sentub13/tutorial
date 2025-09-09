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

    public List<Reviews> getAllReviews() {
        return reviewsRepository.findAll();
    }

    public Reviews createReview(Reviews review) {
        return reviewsRepository.save(review);
    }

    public Optional<Reviews> getReviewById(Long id) {
        return reviewsRepository.findById(id);
    }

    public Reviews updateReview(Long id, Reviews review) {
        return reviewsRepository.save(review);
    }

    public void deleteReview(Long id) {
        reviewsRepository.deleteById(id);
    }
}

