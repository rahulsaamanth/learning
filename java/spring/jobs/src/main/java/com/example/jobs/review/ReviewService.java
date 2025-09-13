package com.example.jobs.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyIdLong);

    boolean addReview(Long companyId, Review review);

    Review getReview(Long companyid, Long reviewId);
}
