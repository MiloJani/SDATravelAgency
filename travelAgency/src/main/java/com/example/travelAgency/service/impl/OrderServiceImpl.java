package com.example.travelAgency.service.impl;

import com.example.travelAgency.dto.orderDTOs.RequestOrderDTO;
import com.example.travelAgency.dto.orderDTOs.ResponseOrderDTO;
import com.example.travelAgency.entity.Order;
import com.example.travelAgency.entity.OrderTour;
import com.example.travelAgency.entity.Tour;
import com.example.travelAgency.mappers.OrderMapper;
import com.example.travelAgency.repository.OrderRepository;
import com.example.travelAgency.repository.OrderTourRepository;
import com.example.travelAgency.repository.TourRepository;
import com.example.travelAgency.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    private OrderTourRepository orderTourRepository;

    private TourRepository tourRepository;

    private OrderMapper orderMapper;

    public ResponseOrderDTO createOrder(RequestOrderDTO requestOrderDTO) {
        Order order = orderMapper.toEntity(requestOrderDTO);
        Order savedOrder = orderRepository.save(order);

        List<OrderTour> orderTours = new ArrayList<>();
        for (Long tourId : requestOrderDTO.getTours()) {
            Tour tour = tourRepository.findById(tourId)
                    .orElseThrow(() -> new RuntimeException("Tour with ID " + tourId + " not found"));

            OrderTour orderTour = new OrderTour();
            orderTour.setOrder(savedOrder);
            orderTour.setTour(tour);

            orderTours.add(orderTour);
        }

        orderTourRepository.saveAll(orderTours);

        return orderMapper.toDto(savedOrder);
    }


    public ResponseOrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));

        return orderMapper.toDto(order);
    }

    public List<ResponseOrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(orderMapper::toDto).collect(Collectors.toList());
    }

    public ResponseOrderDTO updateOrder(Long id, RequestOrderDTO requestOrderDTO) {
        Order existingOrder = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        existingOrder.setOrderDate(requestOrderDTO.getOrderDate());
        List<OrderTour> tours = existingOrder.getTours();

//        for (OrderTour orderTour: tours){
//
//        }
        Order updatedOrder = orderRepository.save(existingOrder);
        return orderMapper.toDto(updatedOrder);
    }

    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        orderRepository.delete(order);
    }
}

