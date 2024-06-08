package com.example.travelAgency.dto.loginDTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterClientDTO extends LoginDTO {

    @NotBlank(message = "Client name is mandatory")
    @Schema(example = "Jonny")
    private String clientName;

    @NotBlank(message = "Phone number is mandatory")
//    @Pattern(regexp = "\\+?[0-9. ()-]{7,25}", message = "Phone number is invalid")
    @Schema(example = "+393331234567")
    private String phoneNumber;

}
