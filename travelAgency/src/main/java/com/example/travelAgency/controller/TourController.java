package com.example.travelAgency.controller;

import com.example.travelAgency.dto.tourDTOs.RequestTourDTO;
import com.example.travelAgency.dto.tourDTOs.ResponseTourDTO;
import com.example.travelAgency.service.TourService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("/api/tour")
@Tag(name = "CRUD REST APIs for Tour Resource")
public class TourController {

    private final TourService tourService;

    @Operation(summary = "Create Tour REST API", description = "Create Tour REST API is used to save tour into database")
    @ApiResponse(responseCode = "201", description = "Http Status 201 CREATED")
    @PostMapping("/save")
    public ResponseEntity<ResponseTourDTO> save(@Valid @RequestBody RequestTourDTO requestTourDTO) {
        return new ResponseEntity<>(tourService.addTour(requestTourDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Find All Tours REST API", description = "Find All Tours REST API is used to fetch all the tours from the database")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @GetMapping("/findAll")
    public ResponseEntity<List<ResponseTourDTO>> findAll() {
        return ResponseEntity.ok(tourService.getAllTours());
    }

    @Operation(summary = "Get Tour By Id REST API", description = "Get Tour By Id REST API is used to get a single tour from the database")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @GetMapping("/findById/{id}")
    public ResponseEntity<ResponseTourDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(tourService.getTourById(id));
    }

    @Operation(summary = "Update Tour REST API", description = "Update Tour REST API is used to update a particular tour in the database")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseTourDTO> update(@Valid @RequestBody RequestTourDTO requestTourDTO, @PathVariable("id") Long id) {
        return ResponseEntity.ok(tourService.updateTour(requestTourDTO, id));
    }

    @Operation(summary = "Delete Tour REST API", description = "Delete Tour REST API is used to delete a particular tour from the database")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        tourService.deleteTour(id);
        return ResponseEntity.ok("Tour with id: " + id + " was successfully deleted!");
    }

    @Operation(summary = "Search Tour REST API", description = "Search Tour REST API is used to search tours based on the query")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @GetMapping("/search")
    public ResponseEntity<List<ResponseTourDTO>> searchTours(@RequestParam(value = "tourName", required = false) String tourName,
                                                             @RequestParam(value = "startDate", required = false) LocalDate startDate,
                                                             @RequestParam(value = "endDate", required = false) LocalDate endDate,
                                                             @RequestParam(value = "price", required = false) Double price,
                                                             @RequestParam(value = "startingCity", required = false) String startingCity,
                                                             @RequestParam(value = "destinationCity", required = false) String destinationCity,
                                                             @RequestParam(value = "category", required = false) String category) {
        return ResponseEntity.ok(tourService.searchTours(tourName, startDate, endDate, price, startingCity, destinationCity, category));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ResponseTourDTO>> filterTours(@RequestParam(value = "tourName", required = false) String tourName,
                                                             @RequestParam(value = "startDate", required = false) LocalDate startDate,
                                                             @RequestParam(value = "endDate", required = false) LocalDate endDate,
                                                             @RequestParam(value = "price", required = false) Double price,
                                                             @RequestParam(value = "startingCity", required = false) String startingCity,
                                                             @RequestParam(value = "destinationCity", required = false) String destinationCity,
                                                             @RequestParam(value = "category", required = false) String category) {
        return ResponseEntity.ok(tourService.filterTours(tourName, startDate, endDate, price, startingCity, destinationCity, category));
    }
}
