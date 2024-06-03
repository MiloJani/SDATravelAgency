package com.example.travelAgency.controller;

import com.example.travelAgency.dto.loginDTOs.LoginDTO;
import com.example.travelAgency.dto.loginDTOs.RegisterClientDTO;
import com.example.travelAgency.dto.loginDTOs.RegisterStaffDTO;
import com.example.travelAgency.service.impl.AuthService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO){

        return ResponseEntity.ok(authService.login(loginDTO));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterClientDTO registerClientDTO){

        return ResponseEntity.ok(authService.register(registerClientDTO));
    }

    @PostMapping("/registerStaff")
    @PreAuthorize("hasRole('MANAGER')")
    @SecurityRequirement(name = "basicAuth")
    public ResponseEntity<String> registerStaff(@RequestBody RegisterStaffDTO registerStaffDTO){

        return ResponseEntity.ok(authService.registerStaff(registerStaffDTO));
    }

}
