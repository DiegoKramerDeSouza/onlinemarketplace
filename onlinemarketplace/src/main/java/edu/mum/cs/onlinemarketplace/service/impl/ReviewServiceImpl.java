package edu.mum.cs.onlinemarketplace.service.impl;


import edu.mum.cs.onlinemarketplace.domain.Review;
import edu.mum.cs.onlinemarketplace.repository.ReviewRepository;
import edu.mum.cs.onlinemarketplace.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public List<Review> getReviewsByProduct(Long id) { return reviewRepository.findReviewsById(id); }

    @Override
    public void addReview(Review review) { reviewRepository.save(review);}
}
