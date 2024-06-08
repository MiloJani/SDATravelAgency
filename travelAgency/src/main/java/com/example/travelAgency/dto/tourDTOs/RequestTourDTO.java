package com.example.travelAgency.dto.tourDTOs;

import com.example.travelAgency.entity.Client;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestTourDTO {

    @NotBlank(message = "Tour name is mandatory")
    @Schema(example = "Summer tour")
    private String tourName;

    @NotNull(message = "Start date is mandatory")
    @FutureOrPresent(message = "Start date must be in the present or future")
    @Schema(example = "2024-07-07")
   private LocalDate startDate;

    @NotNull(message = "End date is mandatory")
    @Schema(example = "2024-08-08")
    private LocalDate endDate;

    @NotNull(message = "Price is mandatory")
    @Positive(message = "Price must be positive")
    @Schema(example = "1000")
    private Double price;

    @NotBlank(message = "Starting city is mandatory")
    @Schema(example = "Tirana")
    private String startingCity;

    @NotBlank(message = "Destination city is mandatory")
    @Schema(example = "Paris")
    private String destinationCity;

    @NotNull(message = "Category ID is mandatory")
    private Long categoryId;
}
