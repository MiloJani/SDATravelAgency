package com.example.travelAgency.mappers;

import com.example.travelAgency.dto.roleDTOs.RequestRoleDTO;
import com.example.travelAgency.dto.userDTOs.RequestUserDTO;
import com.example.travelAgency.dto.userDTOs.ResponseUserDTO;
import com.example.travelAgency.entity.Role;
import com.example.travelAgency.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class UserMapper {

    private final RoleMapper roleMapper;

    public ResponseUserDTO mapToResponseUserDto(User user) {
        ResponseUserDTO responseUserDto = new ResponseUserDTO();
        responseUserDto.setId(user.getUserId());
        responseUserDto.setUsername(user.getUsername());
        responseUserDto.setEmail(user.getEmail());
        responseUserDto.setPassword(user.getPassword());
        Set<Role> roles = user.getRole();
        responseUserDto.setRoles(roles.stream().map(roleMapper::mapToResponseRoleDto).collect(Collectors.toList()));

        return responseUserDto;
    }


    public User mapToUser(RequestUserDTO requestUserDTO) {
        User user = new User();
        user.setUsername(requestUserDTO.getUsername());
        user.setPassword(requestUserDTO.getPassword());
        user.setEmail(requestUserDTO.getEmail());
        List<RequestRoleDTO> roles = requestUserDTO.getRoles();
        user.setRole(roles.stream().map(roleMapper::mapToRole).collect(Collectors.toSet()));

        return user;
    }
}
