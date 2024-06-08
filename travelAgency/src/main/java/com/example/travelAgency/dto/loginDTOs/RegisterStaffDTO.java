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
    @Pattern(regexp = "\\+355\\d{9}", message = "Phone number is invalid. It should start with +355 followed by 9 digits")
    @Schema(example = "+355123456789")
    private String phoneNumber;

    @Positive(message = "Experience years must be positive")
    @Schema(example = "4")
    private Long experienceYears;
}
