package com.example.travelAgency.service;

import com.example.travelAgency.dto.paymentDTOs.RequestPaymentDTO;
import com.example.travelAgency.dto.paymentDTOs.ResponsePaymentDTO;

public interface PaymentService {
    ResponsePaymentDTO getPaymentById(Long paymentId, Long orderId);
    ResponsePaymentDTO addPayment(RequestPaymentDTO requestPaymentDTO, Long orderId);
    ResponsePaymentDTO updatePayment(RequestPaymentDTO requestPaymentDTO, Long paymentId, Long orderId);
    void deletePayment(Long paymentId, Long orderId);
}
