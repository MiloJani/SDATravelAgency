package com.example.travelAgency.dto.tourDTOs;

import com.example.travelAgency.entity.Client;
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

    private String tourName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double price;
    private String startingCity;
    private String destinationCity;
    private Long categoryId;
}
