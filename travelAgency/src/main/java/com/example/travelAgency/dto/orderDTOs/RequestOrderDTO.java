package com.example.travelAgency.dto.orderDTOs;

import com.example.travelAgency.dto.orderTourDTOs.RequestOrderTourDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestOrderDTO {

    @NotNull(message = "Order date is mandatory")
    @FutureOrPresent(message = "Order date must be in the present or future")
    @Schema(example = "2014-02-09")
    private LocalDateTime orderDate;

    @NotNull(message = "Client ID is mandatory")
    private Long clientId;

    @NotEmpty(message = "Tours list cannot be empty")
    private List<Long> tours;
}
