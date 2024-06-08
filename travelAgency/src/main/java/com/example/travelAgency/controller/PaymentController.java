//package com.example.travelAgency.controller;
//
//import com.example.travelAgency.dto.paymentDTOs.RequestPaymentDTO;
//import com.example.travelAgency.dto.paymentDTOs.ResponsePaymentDTO;
//import com.example.travelAgency.service.PaymentService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/payments")
//@RequiredArgsConstructor
//public class PaymentController {
//
//    private final PaymentService paymentService;
//
//    @GetMapping("/{paymentId}/orders/{orderId}")
//    public ResponseEntity<ResponsePaymentDTO> getPaymentById(@PathVariable Long paymentId, @PathVariable Long orderId) {
//        ResponsePaymentDTO payment = paymentService.getPaymentById(paymentId, orderId);
//        return ResponseEntity.ok(payment);
//    }
//
//    @PostMapping("/orders/{orderId}")
//    public ResponseEntity<ResponsePaymentDTO> addPayment(@Validated @RequestBody RequestPaymentDTO requestPaymentDTO, @PathVariable Long orderId) {
//        ResponsePaymentDTO createdPayment = paymentService.addPayment(requestPaymentDTO, orderId);
//        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{paymentId}/orders/{orderId}")
//    public ResponseEntity<ResponsePaymentDTO> updatePayment(@Validated @RequestBody RequestPaymentDTO requestPaymentDTO, @PathVariable Long paymentId, @PathVariable Long orderId) {
//        ResponsePaymentDTO updatedPayment = paymentService.updatePayment(requestPaymentDTO, paymentId, orderId);
//        return ResponseEntity.ok(updatedPayment);
//    }
//
//    @DeleteMapping("/{paymentId}/orders/{orderId}")
//    public ResponseEntity<Void> deletePayment(@PathVariable Long paymentId, @PathVariable Long orderId) {
//        paymentService.deletePayment(paymentId, orderId);
//        return ResponseEntity.noContent().build();
//    }
//}
