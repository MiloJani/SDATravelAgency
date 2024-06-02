package com.example.travelAgency.dto.loginDTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {


    private String username;
    private String email;

    @NotBlank(message = "Password cannot be empty")
    private String password;

}
