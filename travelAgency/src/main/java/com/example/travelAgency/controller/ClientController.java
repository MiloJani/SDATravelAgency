package com.example.travelAgency.controller;

import com.example.travelAgency.dto.clientDTOs.RequestClientDTO;
import com.example.travelAgency.dto.clientDTOs.ResponseClientDTO;
import com.example.travelAgency.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/clients")
@Tag(name = "CRUD REST APIs for Client Resource")
public class ClientController {

    private final ClientService clientService;

    @Operation(
            summary = "Create Client REST API",
            description = "Create Client REST API is used to save a client into the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )
    @PostMapping("/save")
    public ResponseEntity<ResponseClientDTO> saveClient(@RequestBody RequestClientDTO requestClientDTO) {
        return new ResponseEntity<>(clientService.saveClient(requestClientDTO), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Find Client By Id REST API",
            description = "Find Client By Id REST API is used to get a single client from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @GetMapping("/findById/{id}")
    public ResponseEntity<ResponseClientDTO> findClientById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.findClientById(id));
    }

    @Operation(
            summary = "Find All Clients REST API",
            description = "Find All Clients REST API is used to fetch all the clients from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @GetMapping("/findAll")
    public ResponseEntity<List<ResponseClientDTO>> findAllClients() {
        return ResponseEntity.ok(clientService.findAllClients());
    }

    @Operation(
            summary = "Update Client REST API",
            description = "Update Client REST API is used to update a client in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseClientDTO> updateClient(@PathVariable Long id, @RequestBody RequestClientDTO requestClientDTO) {
        return ResponseEntity.ok(clientService.updateClient(id, requestClientDTO));
    }

    @Operation(
            summary = "Delete Client REST API",
            description = "Delete Client REST API is used to delete a client from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClientById(id);
        return ResponseEntity.ok().build();
    }
}

