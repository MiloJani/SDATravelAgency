package com.example.travelAgency.dto.reviewDTOs;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseReviewDTO {

    private Long reviewId;
    private String description;
    private Long tourId;
}
