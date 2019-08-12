package edu.mum.cs.onlinemarketplace.service;

import edu.mum.cs.onlinemarketplace.domain.Review;

import java.util.List;

public interface ReviewService {
    List<Review>getAllReview();
    Review save(Review review);
    Long delete(Long id);
    Review findReviewById(Long id);
}
