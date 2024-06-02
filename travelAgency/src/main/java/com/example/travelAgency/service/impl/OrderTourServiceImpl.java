package com.example.travelAgency.service.impl;

import com.example.travelAgency.dto.orderTourDTOs.RequestOrderTourDTO;
import com.example.travelAgency.dto.orderTourDTOs.ResponseOrderTourDTO;
import com.example.travelAgency.entity.OrderTour;
import com.example.travelAgency.entity.Tour;
import com.example.travelAgency.mappers.OrderTourMapper;
import com.example.travelAgency.repository.OrderTourRepository;
import com.example.travelAgency.repository.TourRepository;
import com.example.travelAgency.service.OrderTourService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderTourServiceImpl implements OrderTourService {

    private OrderTourRepository orderTourRepository;

    private OrderTourMapper orderTourMapper;
    private TourRepository tourRepository;

    public ResponseOrderTourDTO createOrderTour(RequestOrderTourDTO requestOrderTourDTO) {
        OrderTour orderTour = orderTourMapper.toEntity(requestOrderTourDTO);
        OrderTour savedOrderTour = orderTourRepository.save(orderTour);
        return orderTourMapper.toDto(savedOrderTour);
    }

    public ResponseOrderTourDTO getOrderTourById(Long id) {
        OrderTour orderTour = orderTourRepository.findById(id).orElseThrow(() -> new RuntimeException("OrderTour not found"));
        Tour tour = tourRepository.findById(orderTour.getTour().getTourId()).orElseThrow(()->new RuntimeException("No tour"));
        orderTour.setTour(tour);
        return orderTourMapper.toDto(orderTour);
    }

    public List<ResponseOrderTourDTO> getAllOrderTours() {
        List<OrderTour> orderTours = orderTourRepository.findAll();
        for (OrderTour orderT:orderTours){
            Tour tour = tourRepository.findById(orderT.getTour().getTourId()).orElseThrow(()->new RuntimeException("No tour"));
            orderT.setTour(tour);
        }
        return orderTours.stream().map(orderTourMapper::toDto).collect(Collectors.toList());
    }

    public ResponseOrderTourDTO updateOrderTour(Long id, RequestOrderTourDTO requestOrderTourDTO) {
        OrderTour existingOrderTour = orderTourRepository.findById(id).orElseThrow(() -> new RuntimeException("OrderTour not found"));

        Tour tour = new Tour();
        tour.setTourId(requestOrderTourDTO.getTourId());
        existingOrderTour.setTour(tour);

        OrderTour updatedOrderTour = orderTourRepository.save(existingOrderTour);
        return orderTourMapper.toDto(updatedOrderTour);
    }

    public void deleteOrderTour(Long id) {
        OrderTour orderTour = orderTourRepository.findById(id).orElseThrow(() -> new RuntimeException("OrderTour not found"));
        orderTourRepository.delete(orderTour);
    }
}

