package com.example.travelAgency.service.impl;

import com.example.travelAgency.dto.loginDTOs.LoginDTO;
import com.example.travelAgency.repository.RoleRepository;
import com.example.travelAgency.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;

    public String login(LoginDTO loginDTO){
        String usernameOrEmail;
        if (loginDTO.getUsername()!=null){
            usernameOrEmail=loginDTO.getUsername();
        }else {
            usernameOrEmail=loginDTO.getEmail();
        }

        Authentication authentication = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(usernameOrEmail,loginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "E";
    }


}
