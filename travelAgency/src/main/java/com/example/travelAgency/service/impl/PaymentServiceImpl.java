package com.example.travelAgency.service.impl;

import com.example.travelAgency.dto.paymentDTOs.RequestPaymentDTO;
import com.example.travelAgency.dto.paymentDTOs.ResponsePaymentDTO;
import com.example.travelAgency.entity.Order;
import com.example.travelAgency.entity.Payment;
import com.example.travelAgency.mappers.PaymentMapper;
import com.example.travelAgency.repository.OrderRepository;
import com.example.travelAgency.repository.PaymentRepository;
import com.example.travelAgency.service.PaymentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    @Override
    public ResponsePaymentDTO getPaymentById(Long paymentId, Long orderId) {
        Payment payment = paymentRepository.findByPaymentIdAndOrderId(paymentId, orderId)
                .orElseThrow(() -> new EntityNotFoundException("Payment not found with id " + paymentId + " and order id " + orderId));
        return PaymentMapper.toDto(payment);
    }

    @Override
    public ResponsePaymentDTO addPayment(RequestPaymentDTO requestPaymentDTO, Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id " + orderId));
        Payment payment = PaymentMapper.toEntity(requestPaymentDTO);
        payment.setOrder(orderRepository.findById(orderId).orElseThrow(() -> new EntityNotFoundException("Order not found with id " + orderId)));
        payment = paymentRepository.save(payment);
        return PaymentMapper.toDto(payment);
    }

    @Override
    public ResponsePaymentDTO updatePayment(RequestPaymentDTO requestPaymentDTO, Long paymentId, Long orderId) {
        Payment existingPayment = paymentRepository.findByPaymentIdAndOrderId(paymentId, orderId)
                .orElseThrow(() -> new EntityNotFoundException("Payment not found with id " + paymentId + " and order id " + orderId));
        existingPayment.setCardNumber(requestPaymentDTO.getCardNumber());
        existingPayment.setCardHolderName(requestPaymentDTO.getCardHolderName());
        existingPayment.setExpirationYear(requestPaymentDTO.getExpirationYear());
        existingPayment.setExpirationMonth(requestPaymentDTO.getExpirationMonth());
        existingPayment.setCvv(requestPaymentDTO.getCvv());
        existingPayment = paymentRepository.save(existingPayment);
        return PaymentMapper.toDto(existingPayment);
    }

    @Override
    public void deletePayment(Long paymentId, Long orderId) {
        Payment payment = paymentRepository.findByPaymentIdAndOrderId(paymentId, orderId)
                .orElseThrow(() -> new EntityNotFoundException("Payment not found with id " + paymentId + " and order id " + orderId));
        paymentRepository.delete(payment);
    }
}
