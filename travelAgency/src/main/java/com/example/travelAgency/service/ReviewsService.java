package com.example.travelAgency.service;

import com.example.travelAgency.dto.reviewDTOs.RequestReviewDTO;
import com.example.travelAgency.dto.reviewDTOs.ResponseReviewDTO;
import com.example.travelAgency.dto.tourDTOs.RequestTourDTO;
import com.example.travelAgency.entity.Reviews;

import java.util.List;

public interface ReviewsService {
    ResponseReviewDTO getReviewById(Long reviewId,Long tourId);
    List<ResponseReviewDTO> getReviewsByTourId(Long tourId);
    ResponseReviewDTO addReview(RequestReviewDTO requestReviewDTO, Long tourId);
    ResponseReviewDTO updateReview(RequestReviewDTO requestReviewDTO, Long reviewId,Long tourId);
    void deleteReview(Long reviewId,Long tourId);



}
