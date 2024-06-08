package com.example.travelAgency.dto.orderTourDTOs;

import com.example.travelAgency.dto.tourDTOs.ResponseTourDTO;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseOrderTourDTO {

    @NotNull(message = "ID is mandatory")
    private Long id;

    @NotNull(message = "Tour details are mandatory")
    private ResponseTourDTO tour;
}
