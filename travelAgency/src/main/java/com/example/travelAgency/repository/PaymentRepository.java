package com.example.travelAgency.repository;

import com.example.travelAgency.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByPaymentIdAndOrderId(Long paymentId, Long orderId);
}
