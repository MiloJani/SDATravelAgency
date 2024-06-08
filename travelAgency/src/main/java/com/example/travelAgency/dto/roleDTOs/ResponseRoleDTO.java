package com.example.travelAgency.dto.roleDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseRoleDTO {

    @NotNull(message = "ID is mandatory")
    private Long id;

    @NotBlank(message = "Role name is mandatory")
    private String roleName;
}
