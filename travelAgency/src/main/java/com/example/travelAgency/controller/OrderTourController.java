//package com.example.travelAgency.controller;
//
//import com.example.travelAgency.dto.orderTourDTOs.RequestOrderTourDTO;
//import com.example.travelAgency.dto.orderTourDTOs.ResponseOrderTourDTO;
//import com.example.travelAgency.service.OrderTourService;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import lombok.AllArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@CrossOrigin(origins = "http://localhost:3000")
//@AllArgsConstructor
//@RestController
//@RequestMapping("/api/orderTours")
//@Tag(name = "CRUD REST APIs for OrderTour Resource")
//public class OrderTourController {
//
//    private final OrderTourService orderTourService;
//
//    @Operation(
//            summary = "Create OrderTour REST API",
//            description = "Create OrderTour REST API is used to save an order tour into the database"
//    )
//    @ApiResponse(responseCode = "201", description = "Http Status 201 CREATED")
//    @PostMapping("/createOrderTour")
//    public ResponseEntity<ResponseOrderTourDTO> createOrderTour(@RequestBody RequestOrderTourDTO requestOrderTourDTO) {
//        return new ResponseEntity<>(orderTourService.createOrderTour(requestOrderTourDTO), HttpStatus.CREATED);
//    }
//
//    @Operation(
//            summary = "Get OrderTour By Id REST API",
//            description = "Get OrderTour By Id REST API is used to get a single order tour by its ID from the database"
//    )
//    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
//    @GetMapping("/{orderTourId}")
//    public ResponseEntity<ResponseOrderTourDTO> getOrderTourById(@PathVariable Long orderTourId) {
//        return ResponseEntity.ok(orderTourService.getOrderTourById(orderTourId));
//    }
//
//    @Operation(
//            summary = "Get All OrderTours REST API",
//            description = "Get All OrderTours REST API is used to fetch all order tours from the database"
//    )
//    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
//    @GetMapping("/all")
//    public ResponseEntity<List<ResponseOrderTourDTO>> getAllOrderTours() {
//        return ResponseEntity.ok(orderTourService.getAllOrderTours());
//    }
//
//    @Operation(
//            summary = "Update OrderTour REST API",
//            description = "Update OrderTour REST API is used to update a particular order tour in the database"
//    )
//    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
//    @PutMapping("/update/{orderTourId}")
//    public ResponseEntity<ResponseOrderTourDTO> updateOrderTour(@RequestBody RequestOrderTourDTO requestOrderTourDTO, @PathVariable Long orderTourId) {
//        return ResponseEntity.ok(orderTourService.updateOrderTour(orderTourId, requestOrderTourDTO));
//    }
//
//    @Operation(
//            summary = "Delete OrderTour REST API",
//            description = "Delete OrderTour REST API is used to delete a particular order tour from the database"
//    )
//    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
//    @DeleteMapping("/delete/{orderTourId}")
//    public ResponseEntity<String> deleteOrderTour(@PathVariable Long orderTourId) {
//        orderTourService.deleteOrderTour(orderTourId);
//        return ResponseEntity.ok("Order tour with id: " + orderTourId + " was successfully deleted");
//    }
//}
//
