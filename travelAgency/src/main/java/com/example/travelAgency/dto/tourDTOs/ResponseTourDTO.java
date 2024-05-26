package com.example.travelAgency.dto.tourDTOs;

import com.example.travelAgency.dto.reviewDTOs.ResponseReviewDTO;
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

    private Long tourId;
    private String tourName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double price;
    private String startingCity;
    private String destinationCity;
    private Long categoryId;
    private Set<ResponseReviewDTO> responseReviewDTOS;
}
