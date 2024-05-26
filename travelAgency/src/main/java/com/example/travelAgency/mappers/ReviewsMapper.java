package com.example.travelAgency.mappers;

import com.example.travelAgency.entity.Reviews;
import org.springframework.stereotype.Component;

@Component
public class ReviewsMapper {

    public Reviews mapToReviews(Reviews reviews){
        return reviews.builder().reviewId(reviews.getReviewId())
                .description(reviews.getDescription())
                .build();
    }


}
