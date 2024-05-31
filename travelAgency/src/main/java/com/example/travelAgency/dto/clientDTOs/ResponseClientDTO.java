package com.example.travelAgency.dto.clientDTOs;

import com.example.travelAgency.dto.tourDTOs.ResponseTourDTO;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseClientDTO {

    private Long clientId;
    private String clientName;
    private String phoneNumber;
    private Set<ResponseTourDTO> tours;  // You can define a TourDTO to represent tour details
}
