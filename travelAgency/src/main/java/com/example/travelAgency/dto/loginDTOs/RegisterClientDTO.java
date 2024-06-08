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
    @Pattern(regexp = "\\+355\\d{9}", message = "Phone number is invalid. It should start with +355 followed by 9 digits")
    @Schema(example = "+355123456789")
    private String phoneNumber;

}
