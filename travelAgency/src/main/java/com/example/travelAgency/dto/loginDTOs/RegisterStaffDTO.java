package com.example.travelAgency.dto.loginDTOs;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterStaffDTO extends LoginDTO {

    @NotBlank(message = "Staff name is mandatory")
    @Schema(example = "Ben")
    private String staffName;

    @NotBlank(message = "Phone number is mandatory")
    @Pattern(regexp = "\\+?[0-9. ()-]{7,25}", message = "Phone number is invalid")
    @Schema(example = "+393331234567")
    private String phoneNumber;

    @Positive(message = "Experience years must be positive")
    @Schema(example = "4")
    private Long experienceYears;
}
