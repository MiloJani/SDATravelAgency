package com.example.travelAgency.service;

import com.example.travelAgency.dto.reviewDTOs.ResponseReviewDTO;
import com.example.travelAgency.entity.Reviews;

import java.util.List;

public interface ReviewsService {
    List<Reviews> getAllReviews();
    ResponseReviewDTO getReviewById(Long id);
    ResponseReviewDTO addReview(Reviews reviews);
    ResponseReviewDTO updateReview(Reviews reviews, Long id);
    Long deleteReview(Long id);



}
