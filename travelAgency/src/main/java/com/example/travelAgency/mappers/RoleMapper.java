package com.example.travelAgency.mappers;

import com.example.travelAgency.dto.roleDTOs.RequestRoleDTO;
import com.example.travelAgency.dto.roleDTOs.ResponseRoleDTO;
import com.example.travelAgency.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    public ResponseRoleDTO mapToResponseRoleDto(Role role) {
        ResponseRoleDTO responseRoleDto = new ResponseRoleDTO();
        responseRoleDto.setId(role.getRoleId());
        responseRoleDto.setRoleName(role.getRoleName());
        return responseRoleDto;
    }

    public Role mapToRole(RequestRoleDTO requestRoleDTO) {
        Role role = new Role();
        role.setRoleName(requestRoleDTO.getRoleName());
        return role;
    }
}