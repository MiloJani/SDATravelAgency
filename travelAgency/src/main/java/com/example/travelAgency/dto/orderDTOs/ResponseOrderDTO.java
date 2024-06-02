package com.example.travelAgency.dto.orderDTOs;

import com.example.travelAgency.dto.clientDTOs.ResponseClientDTO;
import com.example.travelAgency.dto.orderTourDTOs.ResponseOrderTourDTO;
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
    private Long id;
    private LocalDateTime orderDate;
    private Long clientId;
    private List<ResponseOrderTourDTO> tours;
}
