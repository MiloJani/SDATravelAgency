package com.example.travelAgency.mappers;

import com.example.travelAgency.dto.clientDTOs.ResponseClientDTO;
import com.example.travelAgency.dto.reviewDTOs.ResponseReviewDTO;
import com.example.travelAgency.dto.tourDTOs.RequestTourDTO;
import com.example.travelAgency.dto.tourDTOs.ResponseTourDTO;
import com.example.travelAgency.entity.Client;
import com.example.travelAgency.entity.Reviews;
import com.example.travelAgency.entity.Tour;
import com.example.travelAgency.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class TourMapper {
    private ReviewsMapper reviewsMapper;
    private ClientMapper clientMapper;
    private ClientRepository clientRepository;
    public ResponseTourDTO mapToTourDTO(Tour tour) {

            ResponseTourDTO responseTourDTO=new ResponseTourDTO();
            responseTourDTO.setTourId(tour.getTourId());
            responseTourDTO.setTourName(tour.getTourName());
            responseTourDTO.setPrice(tour.getPrice());
            responseTourDTO.setStartDate(tour.getStartDate());
            responseTourDTO.setEndDate(tour.getEndDate());
            responseTourDTO.setStartingCity(tour.getStartingCity());
            responseTourDTO.setDestinationCity(tour.getDestinationCity());

            Set<Reviews> reviews = tour.getReviews();
            if (reviews!=null){
                    Set<ResponseReviewDTO> responseReviewDTOS = new HashSet<>();
                    for (Reviews review:reviews){
                            responseReviewDTOS.add(reviewsMapper.mapToReviewsDTO(review));
                    }
                    responseTourDTO.setResponseReviewDTOS(responseReviewDTOS);
            }else responseTourDTO.setResponseReviewDTOS(Collections.emptySet());

//  responseTourDTO.setResponseReviewDto(tour.getReviews().stream().map(review -> reviewMapper.mapToReviewsDTO(review)).collect(Collectors.toSet()));
            responseTourDTO.setCategoryId(tour.getCategory().getCategoryId());


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
            tour.setTourName(requestTourDTO.getTourName());
            tour.setPrice(requestTourDTO.getPrice());
            tour.setStartDate(requestTourDTO.getStartDate());
            tour.setEndDate(requestTourDTO.getEndDate());
            tour.setStartingCity(requestTourDTO.getStartingCity());
            tour.setDestinationCity(requestTourDTO.getDestinationCity());

            return tour;


    }


}
