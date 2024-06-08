package com.example.travelAgency.dto.tourDTOs;

import com.example.travelAgency.dto.clientDTOs.ResponseClientDTO;
import com.example.travelAgency.dto.reviewDTOs.ResponseReviewDTO;
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
    private Long tourId;

    @NotBlank(message = "Tour name is mandatory")
    private String tourName;

    @NotNull(message = "Start date is mandatory")
    private LocalDate startDate;

    @NotNull(message = "End date is mandatory")
    private LocalDate endDate;

    @NotNull(message = "Price is mandatory")
    @Positive(message = "Price must be positive")
    private Double price;

    @NotBlank(message = "Starting city is mandatory")
    private String startingCity;

    @NotBlank(message = "Destination city is mandatory")
    private String destinationCity;

    @NotNull(message = "Category ID is mandatory")
    private Long categoryId;

    private Set<ResponseReviewDTO> responseReviewDTOS;
}
