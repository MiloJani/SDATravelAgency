package com.example.travelAgency.dto.reviewDTOs;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestReviewDTO {

    private String description;
    private String email;
}
