package com.example.travelAgency.dto.orderDTOs;

import com.example.travelAgency.dto.orderTourDTOs.RequestOrderTourDTO;
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

    private LocalDateTime orderDate;
    private Long clientId;
    private List<Long> tours;
}
