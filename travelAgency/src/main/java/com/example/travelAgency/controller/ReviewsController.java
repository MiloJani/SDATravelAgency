package com.example.travelAgency.controller;

import com.example.travelAgency.dto.reviewDTOs.RequestReviewDTO;
import com.example.travelAgency.dto.reviewDTOs.ResponseReviewDTO;
import com.example.travelAgency.service.ReviewsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("/api/reviews")
@Tag(name = "CRUD REST APIs for Review Resource")
public class ReviewsController {

    private final ReviewsService reviewsService;

    @Operation(
            summary = "Leave a Review For a Particular Tour REST API",
            description = "Leave a Review REST API is used to save a Review for a particular Tour in the database"
    )
    @ApiResponse(responseCode = "201", description = "Http Status 201 CREATED")
    @PostMapping("/save/{tourId}")
    public ResponseEntity<ResponseReviewDTO> save(@PathVariable("tourId") Long tourId, @Valid @RequestBody RequestReviewDTO requestReviewDTO) {
        return new ResponseEntity<>(reviewsService.addReview(requestReviewDTO, tourId), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Find All Reviews For a Particular Tour REST API",
            description = "Find All Reviews REST API is used to fetch all the reviews for a particular tour from the database"
    )
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @GetMapping("/findByTourId/{tourId}")
    public ResponseEntity<List<ResponseReviewDTO>> findByTourId(@PathVariable("tourId") Long tourId) {
        return ResponseEntity.ok(reviewsService.getReviewsByTourId(tourId));
    }

    @Operation(
            summary = "Find a Review By Id For a Particular Tour REST API",
            description = "Find Review By Id For a Particular Tour REST API is used to find a single review for a particular tour from the database"
    )
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @GetMapping("/findBy/{tourId}/{reviewId}")
    public ResponseEntity<ResponseReviewDTO> findByReviewId(@PathVariable("tourId") Long tourId, @PathVariable("reviewId") Long reviewId) {
        return ResponseEntity.ok(reviewsService.getReviewById(reviewId, tourId));
    }

    @Operation(
            summary = "Update a Review For a Particular Tour REST API",
            description = "Update Review For a Particular Tour REST API is used to update a particular Review for a particular Tour in the database"
    )
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @PutMapping("/update/{tourId}/{reviewId}")
    public ResponseEntity<ResponseReviewDTO> updateById(@PathVariable("tourId") Long tourId, @PathVariable("reviewId") Long reviewId, @Valid @RequestBody RequestReviewDTO requestReviewDTO) {
        return ResponseEntity.ok(reviewsService.updateReview(requestReviewDTO, reviewId, tourId));
    }

    @Operation(
            summary = "Delete a Review For a Particular Tour REST API",
            description = "Delete Review For a Particular Tour REST API is used to delete a particular Review for a particular Tour from the database"
    )
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @DeleteMapping("/delete/{tourId}/{reviewId}")
    public ResponseEntity<String> deleteById(@PathVariable("tourId") Long tourId, @PathVariable("reviewId") Long reviewId) {
        reviewsService.deleteReview(reviewId, tourId);
        return ResponseEntity.ok("Review with id: " + reviewId + " for tour with id: " + tourId + " was successfully deleted");
    }
}
