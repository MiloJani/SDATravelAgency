package com.example.travelAgency.mappers;

import com.example.travelAgency.dto.reviewDTOs.RequestReviewDTO;
import com.example.travelAgency.dto.reviewDTOs.ResponseReviewDTO;
import com.example.travelAgency.entity.Reviews;
import org.springframework.stereotype.Component;

@Component
public class ReviewsMapper {

    public Reviews mapToReviewsEntity(RequestReviewDTO requestReviewDTO){

        Reviews reviews = new Reviews();
        reviews.setReviewId(requestReviewDTO.getReviewId());
        reviews.setDescription(reviews.getDescription());
        return reviews;
    }

    public ResponseReviewDTO mapToReviewsDTO(Reviews reviews){

        ResponseReviewDTO responseReviewDTO = new ResponseReviewDTO();
        responseReviewDTO.setReviewId(reviews.getReviewId());
        responseReviewDTO.setDescription(responseReviewDTO.getDescription());
        return responseReviewDTO;
    }


}
