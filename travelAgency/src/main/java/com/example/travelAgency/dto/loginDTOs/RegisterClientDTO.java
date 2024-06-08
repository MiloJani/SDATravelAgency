package com.example.travelAgency.dto.loginDTOs;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterClientDTO extends LoginDTO {

    @NotBlank(message = "Client name is mandatory")
    private String clientName;

    @NotBlank(message = "Phone number is mandatory")
//    @Pattern(regexp = "\\+?[0-9. ()-]{7,25}", message = "Phone number is invalid")
    private String phoneNumber;

}
