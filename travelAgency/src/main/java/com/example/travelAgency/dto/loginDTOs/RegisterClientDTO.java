package com.example.travelAgency.dto.loginDTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterClientDTO extends LoginDTO {

    private String clientName;
    private String phoneNumber;

}
