package com.example.travelAgency.dto.userDTOs;

import com.example.travelAgency.dto.roleDTOs.ResponseRoleDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseUserDTO {

    @NotNull(message = "User ID is mandatory")
    private Long id;

    @NotBlank(message = "Username is mandatory")
    private String username;

    @NotBlank(message = "Password is mandatory")
    private String password;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Roles are mandatory")
    private List<ResponseRoleDTO> roles;
}

