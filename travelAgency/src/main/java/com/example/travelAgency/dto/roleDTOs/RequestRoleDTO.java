package com.example.travelAgency.dto.roleDTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequestRoleDTO {

    @NotBlank(message = "Role name must not be blank")
    @Schema(example = "ROLE_USER")
    private String roleName;
}
