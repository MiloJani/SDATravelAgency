package com.example.travelAgency.dto.userDTOs;

import com.example.travelAgency.dto.roleDTOs.ResponseRoleDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseUserDTO {

    @NotNull(message = "User ID is mandatory")
    @Schema(example = "1")
    private Long id;

    @NotBlank(message = "Username is mandatory")
    @Schema(example = "Milo")
    private String username;

    @NotBlank(message = "Password is mandatory")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,}$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character"
    )
    @Schema(example = "Milo@20")
    private String password;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    @Schema(example = "Milo@gmail.com")
    private String email;

    @NotNull(message = "Roles are mandatory")
    private List<ResponseRoleDTO> roles;
}

