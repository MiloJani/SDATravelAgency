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
    @Schema(example = "Nice tour 10/10 recommend")
    private String description;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    @Schema(example = "Milo@gmail.com")
    private String email;
}
