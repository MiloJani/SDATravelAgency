package com.example.travelAgency.dto.orderTourDTOs;

import com.example.travelAgency.dto.tourDTOs.ResponseTourDTO;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(example = "1")
    private Long id;

    @NotNull(message = "Tour details are mandatory")
    private ResponseTourDTO tour;
}
