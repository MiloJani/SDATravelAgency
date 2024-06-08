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
    private Long id;

    @NotNull(message = "Order date is mandatory")
    private LocalDateTime orderDate;

    @NotNull(message = "Client ID is mandatory")
    private Long clientId;

    @NotNull(message = "Tours list cannot be null")
    private List<ResponseOrderTourDTO> tours;

    @NotNull(message = "Payment id cannot be null")
    private Long paymentId;
}
