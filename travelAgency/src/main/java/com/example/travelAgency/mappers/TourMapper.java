package com.example.travelAgency.mappers;

import com.example.travelAgency.dto.categoryDTOs.CategoryDTO;
import com.example.travelAgency.dto.tourDTOs.RequestTourDTO;
import com.example.travelAgency.dto.tourDTOs.ResponseTourDTO;
import com.example.travelAgency.entity.Category;
import com.example.travelAgency.entity.Tour;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class TourMapper {

    public ResponseTourDTO mapToTourDTO(Tour tour) {
            ResponseTourDTO responseTourDTO=new ResponseTourDTO();
            responseTourDTO.setTourId(tour.getTourId());
            responseTourDTO.setTourName(tour.getTourName());
            responseTourDTO.setPrice(tour.getPrice());
            responseTourDTO.setStartDate(tour.getStartDate());
            responseTourDTO.setEndDate(tour.getEndDate());
            responseTourDTO.setStartingCity(tour.getStartingCity());
            responseTourDTO.setDestinationCity(tour.getDestinationCity());
            responseTourDTO.setCategoryId(tour.getCategory().getCategoryId());
            responseTourDTO.setResponseReviewDTOS(new ArrayList<>());
            return responseTourDTO;
//        return ResponseTourDTO.builder()
//                .tourId(tour.getTourId())
//                .tourName(tour.getTourName())
//                .price(tour.getPrice())
//                .startDate(tour.getStartDate())
//                .endDate(tour.getEndDate())
//                .startingCity(tour.getStartingCity())
//                .destinationCity(tour.getDestinationCity())
//                .build();
    }



}
