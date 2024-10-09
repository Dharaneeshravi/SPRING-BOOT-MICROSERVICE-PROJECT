package com.Dharaneesh.REVIEW_MS.Review.ReviewServiceImp;

import com.Dharaneesh.REVIEW_MS.Review.Review;
import com.Dharaneesh.REVIEW_MS.Review.ReviewRepository;
import com.Dharaneesh.REVIEW_MS.Review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceimp implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceimp(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getReview(Long companyId) {

        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean createReview(Review review,Long companyId) {

        if(review!=null && companyId!=null)
        {
            review.setCompanyId(companyId);
            reviewRepository.save(review);
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public Review getReviewById(Long reviewId) {

        return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public boolean updateReviewById(Long reviewId, Review review) {

        Optional<Review> review1=reviewRepository.findById(reviewId);

        if(review1.isPresent())
        {
            Review review2=review1.get();
            review2.setTitle(review.getTitle());
            review2.setDescription(review.getDescription());
            review2.setRating(review.getRating());
            reviewRepository.save(review2);
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean deleteReviewById(Long reviewId) {

        if(reviewRepository.existsById(reviewId))
        {
            reviewRepository.deleteById(reviewId);
            return true;
        }
        else
        {
            return false;
        }
    }
}
