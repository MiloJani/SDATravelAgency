package com.example.travelAgency.dto.orderTourDTOs;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestOrderTourDTO {

    @NotNull(message = "Tour ID is mandatory")
    private Long tourId;
}
