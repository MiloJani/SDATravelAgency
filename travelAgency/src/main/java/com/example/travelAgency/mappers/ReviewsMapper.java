package com.example.travelAgency.mappers;

import com.example.travelAgency.dto.reviewDTOs.RequestReviewDTO;
import com.example.travelAgency.dto.reviewDTOs.ResponseReviewDTO;
import com.example.travelAgency.entity.Reviews;
import org.springframework.stereotype.Component;

@Component
public class ReviewsMapper {

    public Reviews mapToReviewsEntity(RequestReviewDTO requestReviewDTO){

        Reviews review = new Reviews();
        review.setEmail(requestReviewDTO.getEmail());
        review.setDescription(requestReviewDTO.getDescription());
        return review;
    }

    public ResponseReviewDTO mapToReviewsDTO(Reviews reviews){

        ResponseReviewDTO responseReviewDto = new ResponseReviewDTO();
        responseReviewDto.setDescription(reviews.getDescription());
        responseReviewDto.setReviewId(reviews.getReviewId());
        responseReviewDto.setEmail(reviews.getEmail());
        responseReviewDto.setTourId(reviews.getTour().getTourId());

        return responseReviewDto;
    }


}
