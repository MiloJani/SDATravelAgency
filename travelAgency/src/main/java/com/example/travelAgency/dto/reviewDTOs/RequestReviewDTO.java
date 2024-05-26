package com.example.travelAgency.dto.reviewDTOs;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestReviewDTO {

    private Long reviewId;
    private String reviewName;
}
