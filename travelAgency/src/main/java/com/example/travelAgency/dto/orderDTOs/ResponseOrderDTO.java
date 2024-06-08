package com.example.travelAgency.dto.orderDTOs;

import com.example.travelAgency.dto.clientDTOs.ResponseClientDTO;
import com.example.travelAgency.dto.orderTourDTOs.ResponseOrderTourDTO;
import io.swagger.v3.oas.annotations.media.Schema;
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
public class ResponseOrderDTO {

    @NotNull(message = "Order ID is mandatory")
    @Schema(example = "1")
    private Long id;

    @NotNull(message = "Order date is mandatory")
    @Schema(example = "2024-02-09T10:00:00")
    private LocalDateTime orderDate;

    @NotNull(message = "Client ID is mandatory")
    @Schema(example = "1")
    private Long clientId;

    @NotNull(message = "Tours list cannot be null")
    private List<ResponseOrderTourDTO> tours;

    @NotNull(message = "Payment id cannot be null")
    @Schema(example = "1")
    private Long paymentId;
}
