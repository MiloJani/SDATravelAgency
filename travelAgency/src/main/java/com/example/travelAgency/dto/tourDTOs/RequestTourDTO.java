package com.example.travelAgency.dto.tourDTOs;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestTourDTO {

    private String tourName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double price;
    private String startingCity;
    private String destinationCity;
    private Long categoryId;
}
