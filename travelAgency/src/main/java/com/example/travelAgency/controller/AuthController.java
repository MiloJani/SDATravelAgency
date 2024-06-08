package com.example.travelAgency.controller;

import com.example.travelAgency.dto.loginDTOs.LoginDTO;
import com.example.travelAgency.dto.loginDTOs.RegisterClientDTO;
import com.example.travelAgency.dto.loginDTOs.RegisterStaffDTO;
import com.example.travelAgency.service.impl.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
@Tag(name = "CRUD REST APIs for Auth Resource")
public class AuthController {

    private AuthService authService;

    @Operation(
            summary = "Login REST API",
            description = "Login  REST API is used to login a user"
    )
    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO){

        return ResponseEntity.ok(authService.login(loginDTO));
    }

    @Operation(
            summary = "Register Client REST API",
            description = "Register Client REST API is used to register a client in the database"
    )
    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterClientDTO registerClientDTO){

        return ResponseEntity.ok(authService.register(registerClientDTO));
    }

    @Operation(
            summary = "Register Staff REST API",
            description = "Register Staff REST API is used to register a staff memeber in the database"
    )
    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PostMapping("/registerStaff")
    @PreAuthorize("hasRole('MANAGER')")
    @SecurityRequirement(name = "basicAuth")
    public ResponseEntity<String> registerStaff(@RequestBody RegisterStaffDTO registerStaffDTO){

        return ResponseEntity.ok(authService.registerStaff(registerStaffDTO));
    }

}
