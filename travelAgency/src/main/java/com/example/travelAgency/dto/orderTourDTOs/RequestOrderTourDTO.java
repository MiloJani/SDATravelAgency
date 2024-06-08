package com.example.travelAgency.dto.orderTourDTOs;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(example = "1")
    private Long tourId;
}
