package edu.mum.cs.onlinemarketplace.service.impl;

import edu.mum.cs.onlinemarketplace.domain.Review;
import edu.mum.cs.onlinemarketplace.repository.ReviewRepository;
import edu.mum.cs.onlinemarketplace.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {
   @Autowired
   private ReviewRepository reviewRepository;
    @Override
    public List<Review> getAllReview() {
        return reviewRepository.findAll();
    }

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Long delete(Long id) {
         reviewRepository.deleteById(id);
         return id;
    }


    @Override
    public Review findReviewById(Long id) {
        return reviewRepository.findById(id).get();
    }
}
