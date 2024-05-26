package com.example.travelAgency.service.impl;

import com.example.travelAgency.dto.reviewDTOs.RequestReviewDTO;
import com.example.travelAgency.dto.reviewDTOs.ResponseReviewDTO;
import com.example.travelAgency.dto.tourDTOs.RequestTourDTO;
import com.example.travelAgency.entity.Reviews;
import com.example.travelAgency.entity.Tour;
import com.example.travelAgency.mappers.ReviewsMapper;
import com.example.travelAgency.repository.ReviewsRepository;
import com.example.travelAgency.repository.TourRepository;
import com.example.travelAgency.service.ReviewsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ReviewsServiceImpl implements ReviewsService {

    private final ReviewsRepository reviewsRepository;
    private final ReviewsMapper reviewsMapper;

    private final TourRepository tourRepository;


    public ReviewsServiceImpl(ReviewsRepository reviewsRepository, ReviewsMapper reviewsMapper, TourRepository tourRepository) {
        this.reviewsRepository = reviewsRepository;
        this.reviewsMapper = reviewsMapper;
        this.tourRepository = tourRepository;
    }


    @Override
    public ResponseReviewDTO getReviewById(Long reviewId, Long tourId) {
        Tour foundTour = tourRepository.findById(tourId).orElseThrow(
                () -> new RuntimeException("Could not find tour with id:"+tourId));
        Reviews foundReview = reviewsRepository.findById(reviewId).orElseThrow(
                () -> new RuntimeException("Review with id: " + reviewId + " was not found"));

        if (!(Objects.equals(foundTour.getTourId(), foundReview.getTour().getTourId()))){
            throw  new RuntimeException("Tour with id:"+tourId+" does not correspond to review with id:"+reviewId);
        }
        return reviewsMapper.mapToReviewsDTO(foundReview);
    }

    @Override
    public List<ResponseReviewDTO> getReviewsByTourId(Long tourId) {
        List<Reviews> reviews = reviewsRepository.findByTour_TourId(tourId);
        List<ResponseReviewDTO> responseReviewDTOS = new ArrayList<>();
        for (Reviews review:reviews){
            responseReviewDTOS.add(reviewsMapper.mapToReviewsDTO(review));
        }
        return responseReviewDTOS;
    }

    @Override
    public ResponseReviewDTO addReview(RequestReviewDTO requestReviewDTO, Long tourId) {
        Tour foundTour = tourRepository.findById(tourId).orElseThrow(
                () -> new RuntimeException("Could not find tour with id:"+tourId));

        Reviews review = reviewsMapper.mapToReviewsEntity(requestReviewDTO);
        review.setTour(foundTour);
        Reviews savedReview = reviewsRepository.save(review);
        return reviewsMapper.mapToReviewsDTO(savedReview);
    }

    @Override
    public ResponseReviewDTO updateReview(RequestReviewDTO requestReviewDTO, Long reviewId, Long tourId) {
        Tour foundTour = tourRepository.findById(tourId).orElseThrow(
                () -> new RuntimeException("Could not find tour with id:"+tourId));
        Reviews foundReview = reviewsRepository.findById(reviewId).orElseThrow(
                () -> new RuntimeException("Review with id: " + reviewId + " was not found"));
        if (!(Objects.equals(foundTour.getTourId(), foundReview.getTour().getTourId()))){
            throw  new RuntimeException("Tour with id:"+tourId+" does not correspond to review with id:"+reviewId);
        }

        foundReview.setReviewId(reviewId);
        foundReview.setDescription(requestReviewDTO.getDescription());
        foundReview.setEmail(requestReviewDTO.getEmail());
        foundReview.setTour(foundTour);
        Reviews savedReview = reviewsRepository.save(foundReview);
        return reviewsMapper.mapToReviewsDTO(savedReview);
    }

    @Override
    public void deleteReview(Long reviewId, Long tourId) {
        Tour foundTour = tourRepository.findById(tourId).orElseThrow(
                () -> new RuntimeException("Could not find tour with id:"+tourId));
        Reviews foundReview = reviewsRepository.findById(reviewId).orElseThrow(
                () -> new RuntimeException("Review with id: " + reviewId + " was not found"));
        if (!(Objects.equals(foundTour.getTourId(), foundReview.getTour().getTourId()))){
            throw  new RuntimeException("Tour with id:"+tourId+" does not correspond to review with id:"+reviewId);
        }
        reviewsRepository.delete(foundReview);
    }
}
