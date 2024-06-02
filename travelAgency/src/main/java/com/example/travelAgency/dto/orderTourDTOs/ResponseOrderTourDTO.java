package com.example.travelAgency.dto.orderTourDTOs;

import com.example.travelAgency.dto.tourDTOs.ResponseTourDTO;
import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseOrderTourDTO {

    private Long id;
    private ResponseTourDTO tour;
}
