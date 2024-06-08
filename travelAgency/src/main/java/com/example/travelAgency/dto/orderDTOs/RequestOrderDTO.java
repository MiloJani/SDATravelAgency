package com.example.travelAgency.dto.orderDTOs;

import com.example.travelAgency.dto.orderTourDTOs.RequestOrderTourDTO;
import com.example.travelAgency.dto.paymentDTOs.RequestPaymentDTO;
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
    @Schema(example = "2024-02-09T10:00:00")
    private LocalDateTime orderDate;

    @NotNull(message = "Client ID is mandatory")
    @Schema(example = "1")
    private Long clientId;

    @NotEmpty(message = "Tours list cannot be empty")
    @Schema(example = "1, 2, 3")
    private List<Long> tours;

    private RequestPaymentDTO requestPaymentDTO;
}
