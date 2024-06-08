package com.example.travelAgency.dto.clientDTOs;

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
public class RequestClientDTO {

    @NotBlank(message = "Client name is mandatory")
    @Schema(example = "Jonny")
    private String clientName;

    @NotBlank(message = "Phone number is mandatory")
    @Schema(example = "+393331234567")
//    @Pattern(regexp = "\\+?[0-9. ()-]{7,25}", message = "Phone number is invalid")
    private String phoneNumber;
}
