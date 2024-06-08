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

    @Schema(example = "1")
    private Long clientId;

    @NotBlank(message = "Client name is mandatory")
    @Schema(example = "Milo")
    private String clientName;

    @NotBlank(message = "Phone number is mandatory")
    @Pattern(regexp = "\\+355\\d{9}", message = "Phone number is invalid. It should start with +355 followed by 9 digits")
    @Schema(example = "+355123456789")
    private String phoneNumber;
}
