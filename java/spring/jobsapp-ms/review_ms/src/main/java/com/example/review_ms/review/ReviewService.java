package com.example.review_ms.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyIdLong);

    boolean addReview(Long companyId, Review review);

    Review getReview(Long reviewId);

    boolean updateReview(Long reviewId, Review review);

    boolean deleteReview(Long reviewId);
}
