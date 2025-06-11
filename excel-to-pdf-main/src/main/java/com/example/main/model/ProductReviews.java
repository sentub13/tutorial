package com.example.main.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ProductReviews") 
public class ProductReviews {
    
    @Id
    @Column(name = "review_id")
    private Integer reviewId;
    
    @Column(name = "product_id")
    private Integer productId;
    
    @Column(name = "user_id")
    private Integer userId;
    
    @Column(name = "rating")
    private Integer rating;
    
    @Column(name = "comment")
    @Lob
    private String comment;
    
    @Column(name = "review_date")
    private LocalDateTime reviewDate;
    
    // Default constructor
    public ProductReviews() {
    }
    
    // Parameterized constructor
    public ProductReviews(Integer reviewId, Integer productId, Integer userId, 
                         Integer rating, String comment, LocalDateTime reviewDate) {
        this.reviewId = reviewId;
        this.productId = productId;
        this.userId = userId;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }
    
    // Getters and Setters
    public Integer getReviewId() {
        return reviewId;
    }
    
    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }
    
    public Integer getProductId() {
        return productId;
    }
    
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    
    public Integer getUserId() {
        return userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public Integer getRating() {
        return rating;
    }
    
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    
    public String getComment() {
        return comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public LocalDateTime getReviewDate() {
        return reviewDate;
    }
    
    public void setReviewDate(LocalDateTime reviewDate) {
        this.reviewDate = reviewDate;
    }
}