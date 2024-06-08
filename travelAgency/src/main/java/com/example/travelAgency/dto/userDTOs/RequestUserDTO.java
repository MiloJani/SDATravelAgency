package com.example.travelAgency.dto.userDTOs;

import com.example.travelAgency.dto.roleDTOs.RequestRoleDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RequestUserDTO {

    @NotNull(message = "Username cannot be null")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    @Schema(example = "JonnyDoe")
    private String username;

    @NotNull(message = "Password cannot be null")
    @Size(min = 6, max = 100, message = "Password must be between 6 and 100 characters")
    @Schema(example = "abc1234")
    private String password;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    @Schema(example = "user123@gmail.com")
    private String email;

    @Valid
    private List<RequestRoleDTO> roles;
}
