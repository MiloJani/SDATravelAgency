package com.example.travelAgency.service.impl;

import com.example.travelAgency.constants.MessageConstants;
import com.example.travelAgency.dto.orderDTOs.RequestOrderDTO;
import com.example.travelAgency.dto.orderDTOs.ResponseOrderDTO;
import com.example.travelAgency.entity.Order;
import com.example.travelAgency.entity.OrderTour;
import com.example.travelAgency.entity.Payment;
import com.example.travelAgency.entity.Tour;
import com.example.travelAgency.mappers.OrderMapper;
import com.example.travelAgency.repository.OrderRepository;
import com.example.travelAgency.repository.OrderTourRepository;
import com.example.travelAgency.repository.PaymentRepository;
import com.example.travelAgency.repository.TourRepository;
import com.example.travelAgency.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    private OrderTourRepository orderTourRepository;

    private PaymentRepository paymentRepository;

    private TourRepository tourRepository;

    private OrderMapper orderMapper;

    @Transactional
    public ResponseOrderDTO createOrder(RequestOrderDTO requestOrderDTO) {
        Order order = orderMapper.toEntity(requestOrderDTO);
        Order savedOrder = orderRepository.save(order);

        List<OrderTour> orderTours = new ArrayList<>();
        for (Long tourId : requestOrderDTO.getTours()) {
            Tour tour = tourRepository.findById(tourId)
                    .orElseThrow(() -> new RuntimeException(MessageConstants.TOUR_NOT_FOUND));

            OrderTour orderTour = new OrderTour();
            orderTour.setOrder(savedOrder);
            orderTour.setTour(tour);

            orderTours.add(orderTour);
        }

        orderTourRepository.saveAll(orderTours);

        Payment payment = new Payment();
        payment.setCardHolderName(requestOrderDTO.getRequestPaymentDTO().getCardHolderName());
        payment.setCardNumber(requestOrderDTO.getRequestPaymentDTO().getCardNumber());
        payment.setExpirationMonth(requestOrderDTO.getRequestPaymentDTO().getExpirationMonth());
        payment.setExpirationYear(requestOrderDTO.getRequestPaymentDTO().getExpirationYear());
        payment.setCvv(requestOrderDTO.getRequestPaymentDTO().getCvv());
        payment.setOrder(savedOrder);
        paymentRepository.save(payment);

        savedOrder.setPayment(payment);
        orderRepository.save(savedOrder);

        return orderMapper.toDto(savedOrder);
    }


    public ResponseOrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException(MessageConstants.ORDER_NOT_FOUND));

        return orderMapper.toDto(order);
    }

    public List<ResponseOrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(orderMapper::toDto).collect(Collectors.toList());
    }

    public ResponseOrderDTO updateOrder(Long id, RequestOrderDTO requestOrderDTO) {
        Order existingOrder = orderRepository.findById(id).orElseThrow(() -> new RuntimeException(MessageConstants.ORDER_NOT_FOUND));
        existingOrder.setOrderDate(requestOrderDTO.getOrderDate());
        List<OrderTour> tours = existingOrder.getTours();

//        for (OrderTour orderTour: tours){
//
//        }
        Order updatedOrder = orderRepository.save(existingOrder);
        return orderMapper.toDto(updatedOrder);
    }

    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException(MessageConstants.ORDER_NOT_FOUND));
        orderRepository.delete(order);
    }
}

