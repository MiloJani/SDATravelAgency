package com.example.travelAgency.dto.loginDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterStaffDTO extends LoginDTO {

    @NotBlank(message = "Staff name is mandatory")
    private String staffName;

    @NotBlank(message = "Phone number is mandatory")
    @Pattern(regexp = "\\+?[0-9. ()-]{7,25}", message = "Phone number is invalid")
    private String phoneNumber;

    @Positive(message = "Experience years must be positive")
    private Long experienceYears;
}
