package com.example.travelAgency.dto.tourDTOs;

import com.example.travelAgency.dto.clientDTOs.ResponseClientDTO;
import com.example.travelAgency.dto.reviewDTOs.ResponseReviewDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTourDTO {

    @NotNull(message = "Tour ID is mandatory")
    @Schema(example = "1")
    private Long tourId;

    @NotBlank(message = "Tour name is mandatory")
    @Schema(example = "Tirane-Durres")
    private String tourName;

    @NotNull(message = "Start date is mandatory")
    @Schema(example = "2024-06-07")
    private LocalDate startDate;

    @NotNull(message = "End date is mandatory")
    @Schema(example = "2024-06-09")
    private LocalDate endDate;

    @NotNull(message = "Price is mandatory")
    @Positive(message = "Price must be positive")
    @Schema(example = "200")
    private Double price;

    @NotBlank(message = "Starting city is mandatory")
    @Schema(example = "Tirane")
    private String startingCity;

    @NotBlank(message = "Destination city is mandatory")
    @Schema(example = "Durres")
    private String destinationCity;

    @NotNull(message = "Category ID is mandatory")
    @Schema(example = "1")
    private Long categoryId;

    private Set<ResponseReviewDTO> responseReviewDTOS;
}
