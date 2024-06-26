package com.example.travelAgency.service.impl;

import com.example.travelAgency.constants.MessageConstants;
import com.example.travelAgency.dto.userDTOs.RequestUserDTO;
import com.example.travelAgency.dto.userDTOs.ResponseUserDTO;
import com.example.travelAgency.entity.User;
import com.example.travelAgency.mappers.RoleMapper;
import com.example.travelAgency.mappers.UserMapper;
import com.example.travelAgency.repository.UserRepository;
import com.example.travelAgency.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
//    private PasswordEncoder passwordEncoder;
    private RoleMapper roleMapper;

//    public RegisterResponseDTO registerUser(RegisterRequestDTO request) {
//        User user = new User();
//        user.setUsername(request.getUsername());
//        user.setPassword(passwordEncoder.encode(request.getPassword()));
//
//        Client client = new Client();
//        client.setFirstName(request.getFirstName());
//        client.setLastName(request.getLastName());
//        client.setUser(user);
//        user.setClient(client);
//
//        userRepository.save(user);
//        return new RegisterResponseDTO("User registered successfully");
//    }
    public ResponseUserDTO saveUser(RequestUserDTO requestUserDTO) {
        User userEntity = userMapper.mapToUser(requestUserDTO);
//        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        User savedUser = userRepository.save(userEntity);
        return userMapper.mapToResponseUserDto(savedUser);
    }

    public ResponseUserDTO findUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(MessageConstants.TOUR_NOT_FOUND));
        return userMapper.mapToResponseUserDto(user);
    }

    public List<ResponseUserDTO> findAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(userMapper::mapToResponseUserDto)
                .toList();
    }

    public ResponseUserDTO updateUser(Long id, RequestUserDTO requestUserDTO) {
        User userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException(MessageConstants.USER_NOT_FOUND));
        userEntity.setUserId(id);
        userEntity.setUsername(requestUserDTO.getUsername());
//        userEntity.setPassword(passwordEncoder.encode(createUserDto.getPassword()));
        userEntity.setEmail(requestUserDTO.getEmail());
        userEntity.setRole(requestUserDTO.getRoles().stream().map(role->roleMapper.mapToRole(role)).collect(Collectors.toSet()));

        User savedUser = userRepository.save(userEntity);
        return userMapper.mapToResponseUserDto(savedUser);
    }


    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

}
