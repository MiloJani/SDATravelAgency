package com.example.travelAgency.mappers;

import com.example.travelAgency.dto.orderTourDTOs.RequestOrderTourDTO;
import com.example.travelAgency.dto.orderTourDTOs.ResponseOrderTourDTO;
import com.example.travelAgency.entity.OrderTour;
import com.example.travelAgency.entity.Tour;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class OrderTourMapper {

    private TourMapper tourMapper;

    public OrderTour toEntity(RequestOrderTourDTO dto) {
        OrderTour orderTour = new OrderTour();

        Tour tour = new Tour();
        tour.setTourId(dto.getTourId());
        orderTour.setTour(tour);

        return orderTour;
    }


    public ResponseOrderTourDTO toDto(OrderTour orderTour) {
        ResponseOrderTourDTO dto = new ResponseOrderTourDTO();
        dto.setId(orderTour.getId());
        dto.setTour(tourMapper.mapToTourDTO(orderTour.getTour()));

        return dto;
    }
}

