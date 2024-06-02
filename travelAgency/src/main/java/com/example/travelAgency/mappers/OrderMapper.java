package com.example.travelAgency.mappers;

import com.example.travelAgency.dto.clientDTOs.ResponseClientDTO;
import com.example.travelAgency.dto.orderDTOs.RequestOrderDTO;
import com.example.travelAgency.dto.orderDTOs.ResponseOrderDTO;
import com.example.travelAgency.dto.orderTourDTOs.ResponseOrderTourDTO;
import com.example.travelAgency.entity.Client;
import com.example.travelAgency.entity.Order;
import com.example.travelAgency.entity.OrderTour;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OrderMapper {


    private OrderTourMapper orderTourMapper;

    private ClientMapper clientMapper;

    public Order toEntity(RequestOrderDTO dto) {
        Order order = new Order();
        order.setOrderDate(dto.getOrderDate());

        Client client = new Client();
        client.setClientId(dto.getClientId());
        order.setClient(client);

        return order;
    }

    public ResponseOrderDTO toDto(Order order) {
        ResponseOrderDTO dto = new ResponseOrderDTO();
        dto.setId(order.getId());
        dto.setOrderDate(order.getOrderDate());
        dto.setClientId(order.getClient().getClientId());
        return dto;
    }

}
