package com.example.travelAgency.controller;

import com.example.travelAgency.dto.orderDTOs.RequestOrderDTO;
import com.example.travelAgency.dto.orderDTOs.ResponseOrderDTO;
import com.example.travelAgency.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("/api/orders")
@Tag(name = "CRUD REST APIs for Order Resource")
public class OrderController {

    private final OrderService orderService;

    @Operation(
            summary = "Create Order REST API",
            description = "Create Order REST API is used to save an order into the database"
    )
    @ApiResponse(responseCode = "201", description = "Http Status 201 CREATED")
    @PostMapping("/createOrder")
    public ResponseEntity<ResponseOrderDTO> createOrder(@RequestBody RequestOrderDTO requestOrderDTO) {
        return new ResponseEntity<>(orderService.createOrder(requestOrderDTO), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Order By Id REST API",
            description = "Get Order By Id REST API is used to get a single order by its ID from the database"
    )
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @GetMapping("/{orderId}")
    public ResponseEntity<ResponseOrderDTO> getOrderById(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }

    @Operation(
            summary = "Get All Orders REST API",
            description = "Get All Orders REST API is used to fetch all orders from the database"
    )
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @GetMapping("/all")
    public ResponseEntity<List<ResponseOrderDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @Operation(
            summary = "Update Order REST API",
            description = "Update Order REST API is used to update a particular order in the database"
    )
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @PutMapping("/update/{orderId}")
    public ResponseEntity<ResponseOrderDTO> updateOrder(@RequestBody RequestOrderDTO requestOrderDTO, @PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.updateOrder(orderId, requestOrderDTO));
    }

    @Operation(
            summary = "Delete Order REST API",
            description = "Delete Order REST API is used to delete a particular order from the database"
    )
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok("Order with id: " + orderId + " was successfully deleted");
    }
}

