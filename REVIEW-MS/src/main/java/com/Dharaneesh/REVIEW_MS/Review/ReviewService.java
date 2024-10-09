package com.Dharaneesh.REVIEW_MS.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getReview(Long companyId);

    boolean createReview(Review review,Long companyId);

    Review getReviewById(Long reviewId);

    boolean updateReviewById(Long reviewId, Review review);

    boolean deleteReviewById(Long reviewId);
}
