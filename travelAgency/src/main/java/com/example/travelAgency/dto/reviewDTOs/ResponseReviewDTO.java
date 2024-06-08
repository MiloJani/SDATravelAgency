package com.example.travelAgency.dto.reviewDTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseReviewDTO {

    @NotNull(message = "Review ID is mandatory")
    private Long reviewId;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Tour ID is mandatory")
    private Long tourId;
}
