package com.example.travelAgency.dto.userDTOs;

import com.example.travelAgency.dto.roleDTOs.ResponseRoleDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseUserDTO {

    private Long id;
    private String username;
    private String password;
    private String email;
    private List<ResponseRoleDTO> roles;
}

