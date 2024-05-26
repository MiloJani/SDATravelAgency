package com.example.travelAgency.mappers;

import com.example.travelAgency.dto.categoryDTOs.CategoryDTO;
import com.example.travelAgency.dto.tourDTOs.RequestTourDTO;
import com.example.travelAgency.dto.tourDTOs.ResponseTourDTO;
import com.example.travelAgency.entity.Category;
import com.example.travelAgency.entity.Reviews;
import com.example.travelAgency.entity.Tour;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TourMapper {
        private ReviewsMapper reviewsMapper;
    public ResponseTourDTO mapToTourDTO(Tour tour) {

            List<Reviews> reviews = tour.getReviews();

            ResponseTourDTO responseTourDTO=new ResponseTourDTO();
            responseTourDTO.setTourId(tour.getTourId());
            responseTourDTO.setTourName(tour.getTourName());
            responseTourDTO.setPrice(tour.getPrice());
            responseTourDTO.setStartDate(tour.getStartDate());
            responseTourDTO.setEndDate(tour.getEndDate());
            responseTourDTO.setStartingCity(tour.getStartingCity());
            responseTourDTO.setDestinationCity(tour.getDestinationCity());
            responseTourDTO.setCategoryId(tour.getCategory().getCategoryId());
            responseTourDTO.setResponseReviewDTOS(reviews
                    .stream().map(r -> reviewsMapper.mapToReviewsDTO(r) )
                    .collect(Collectors.toList()));
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

    public Tour mapToTourEntity(RequestTourDTO requestTourDTO){
            Tour tour=new Tour();
            tour.setTourId(requestTourDTO.getTourId());
            tour.setTourName(requestTourDTO.getTourName());
            tour.setPrice(requestTourDTO.getPrice());
            tour.setStartDate(requestTourDTO.getStartDate());
            tour.setEndDate(requestTourDTO.getEndDate());
            tour.setStartingCity(requestTourDTO.getStartingCity());
            tour.setDestinationCity(requestTourDTO.getDestinationCity());
            return tour;


    }


}
