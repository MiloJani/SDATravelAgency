package com.example.travelAgency.dto.loginDTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterStaffDTO extends LoginDTO {

    private String staffName;
    private String phoneNumber;
    private Long experienceYears;
}
