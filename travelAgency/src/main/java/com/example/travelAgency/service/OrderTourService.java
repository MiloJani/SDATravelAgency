package com.example.travelAgency.service;

import com.example.travelAgency.dto.orderTourDTOs.RequestOrderTourDTO;
import com.example.travelAgency.dto.orderTourDTOs.ResponseOrderTourDTO;

import java.util.List;

public interface OrderTourService {

    ResponseOrderTourDTO createOrderTour(RequestOrderTourDTO requestOrderTourDTO);
    ResponseOrderTourDTO getOrderTourById(Long id);
    List<ResponseOrderTourDTO> getAllOrderTours();
    ResponseOrderTourDTO updateOrderTour(Long id, RequestOrderTourDTO requestOrderTourDTO);
    void deleteOrderTour(Long id);
}
