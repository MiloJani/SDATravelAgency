package com.example.travelAgency.service;

import com.example.travelAgency.dto.orderDTOs.RequestOrderDTO;
import com.example.travelAgency.dto.orderDTOs.ResponseOrderDTO;
import com.example.travelAgency.dto.orderTourDTOs.ResponseOrderTourDTO;

import java.util.List;

public interface OrderService {

    ResponseOrderDTO createOrder(RequestOrderDTO requestOrderDTO);
    ResponseOrderDTO getOrderById(Long id);
    List<ResponseOrderDTO> getAllOrders();
    ResponseOrderDTO updateOrder(Long id,RequestOrderDTO requestOrderDTO);
    void deleteOrder(Long id);
}
