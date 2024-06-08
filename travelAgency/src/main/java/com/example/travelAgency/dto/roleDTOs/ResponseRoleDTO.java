package com.example.travelAgency.dto.roleDTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseRoleDTO {

    @NotNull(message = "ID is mandatory")
    @Schema(example = "1")
    private Long id;

    @NotBlank(message = "Role name is mandatory")
    @Schema(example = "ROLE_USER")
    private String roleName;
}
