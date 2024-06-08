package com.example.travelAgency.dto.reviewDTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestReviewDTO {

    @NotBlank(message = "Description is mandatory")
    @Schema(example = "Nice tour")
    private String description;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    @Schema(example = "user123@gmail.com")
    private String email;
}
