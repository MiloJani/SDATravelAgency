package com.example.travelAgency.service;

import com.example.travelAgency.entity.Reviews;

import java.util.List;

public interface ReviewsService {
    List<Reviews> getAllReviews();
    Reviews getReviewById(Long id);
    Reviews addReview(Reviews reviews);
    Reviews updateReview(Reviews reviews, Long id);
    Long deleteReview(Long id);



}
