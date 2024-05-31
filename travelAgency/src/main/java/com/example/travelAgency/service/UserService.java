package com.example.travelAgency.service;

import com.example.travelAgency.dto.userDTOs.RequestUserDTO;
import com.example.travelAgency.dto.userDTOs.ResponseUserDTO;

import java.util.List;

public interface UserService {

    ResponseUserDTO saveUser(RequestUserDTO requestUserDTO);
    ResponseUserDTO findUserById(Long id);

    List<ResponseUserDTO> findAllUsers();
    ResponseUserDTO updateUser(Long id,RequestUserDTO requestUserDTO);

    void deleteUserById(Long id);
}
