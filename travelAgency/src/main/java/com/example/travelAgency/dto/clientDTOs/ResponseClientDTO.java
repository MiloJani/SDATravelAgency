package com.example.travelAgency.dto.clientDTOs;

import com.example.travelAgency.dto.tourDTOs.ResponseTourDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseClientDTO {

    private Long clientId;

    @NotBlank(message = "Client name is mandatory")
    private String clientName;

    @NotBlank(message = "Phone number is mandatory")
//    @Pattern(regexp = "\\+?[0-9. ()-]{7,25}", message = "Phone number is invalid")
    private String phoneNumber;
}
