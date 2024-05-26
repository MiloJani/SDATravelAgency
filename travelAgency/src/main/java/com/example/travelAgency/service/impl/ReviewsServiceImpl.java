package com.example.travelAgency.service.impl;

import com.example.travelAgency.dto.reviewDTOs.ResponseReviewDTO;
import com.example.travelAgency.entity.Category;
import com.example.travelAgency.entity.Reviews;
import com.example.travelAgency.mappers.ReviewsMapper;
import com.example.travelAgency.repository.ReviewsRepository;
import com.example.travelAgency.service.ReviewsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewsServiceImpl implements ReviewsService {

    private final ReviewsRepository reviewsRepository;
    private final ReviewsMapper reviewsMapper;


    public ReviewsServiceImpl(ReviewsRepository reviewsRepository, ReviewsMapper reviewsMapper) {
        this.reviewsRepository = reviewsRepository;
        this.reviewsMapper = reviewsMapper;
    }

    @Override
    public List<Reviews> getAllReviews() {
        return reviewsRepository.findAll();
    }

    @Override
    public ResponseReviewDTO getReviewById(Long id) {
        Optional<Reviews> reviewsOptional = reviewsRepository.findById(id);
        if (reviewsOptional.isPresent()) {
            Reviews reviews = reviewsOptional.get();
            return reviewsMapper.mapToReviewsDTO(reviews);
        }

        return null;
    }

    @Override
    public ResponseReviewDTO addReview(Reviews reviews) {
        if (!reviewsRepository.existsById(reviews.getReviewId())) {
            reviewsRepository.save(reviews);
            return reviewsMapper.mapToReviewsDTO(reviews);
        }
        return null;
    }

    @Override
    public ResponseReviewDTO updateReview(Reviews reviews, Long id) {
        Optional<Reviews> reviewsOptional = reviewsRepository.findById(id);
        if (reviewsOptional.isPresent()) {
            Reviews existingReviews = reviewsOptional.get();
            existingReviews.setDescription(reviews.getDescription());
            reviewsRepository.save(existingReviews);
            return reviewsMapper.mapToReviewsDTO(existingReviews);
        }
        return null;
    }

    @Override
    public Long deleteReview(Long id) {
        Optional<Reviews> reviewsOptional = reviewsRepository.findById(id);
        if (reviewsOptional.isPresent()) {
            Reviews existingReviews = reviewsOptional.get();
            reviewsRepository.delete(existingReviews);
            return id;
        }
        return null;
    }
}
