package com.example.travelAgency.mappers;

import com.example.travelAgency.dto.paymentDTOs.RequestPaymentDTO;
import com.example.travelAgency.dto.paymentDTOs.ResponsePaymentDTO;
import com.example.travelAgency.entity.Order;
import com.example.travelAgency.entity.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    public static Payment toEntity(RequestPaymentDTO requestPaymentDTO) {

        Payment payment = new Payment();
        payment.setCardNumber(requestPaymentDTO.getCardNumber());
        payment.setCardHolderName(requestPaymentDTO.getCardHolderName());
        payment.setExpirationYear(requestPaymentDTO.getExpirationYear());
        payment.setExpirationMonth(requestPaymentDTO.getExpirationMonth());
        payment.setCvv(requestPaymentDTO.getCvv());

        return payment;
    }

    public static ResponsePaymentDTO toDto(Payment payment) {


        ResponsePaymentDTO responsePaymentDTO = new ResponsePaymentDTO();
        responsePaymentDTO.setPaymentId(payment.getPaymentId());
        responsePaymentDTO.setCardNumber(payment.getCardNumber());
        responsePaymentDTO.setCardHolderName(payment.getCardHolderName());
        responsePaymentDTO.setExpirationYear(payment.getExpirationYear());
        responsePaymentDTO.setExpirationMonth(payment.getExpirationMonth());
        responsePaymentDTO.setCvv(payment.getCvv());
        responsePaymentDTO.setOrderId(payment.getOrder() != null ? payment.getOrder().getId() : null);

        return responsePaymentDTO;
    }
}
