package com.example.travelAgency.dto.clientDTOs;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestClientDTO {

    private String clientName;
    private String phoneNumber;
}
