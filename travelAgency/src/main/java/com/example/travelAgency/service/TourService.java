package com.example.travelAgency.service;

import com.example.travelAgency.dto.tourDTOs.RequestTourDTO;
import com.example.travelAgency.dto.tourDTOs.ResponseTourDTO;
import com.example.travelAgency.entity.Category;
import com.example.travelAgency.entity.Tour;

import java.time.LocalDate;
import java.util.List;

public interface TourService {
    List<ResponseTourDTO> getAllTours();

    ResponseTourDTO getTourById(Long id) ;

    ResponseTourDTO addTour(RequestTourDTO requestTourDTO) ;

    ResponseTourDTO updateTour(RequestTourDTO requestTourDTO, Long id) ;

    void deleteTour(Long id) ;

    List<ResponseTourDTO> searchTours(
            String tourName,LocalDate startDate,LocalDate endDate,Double price,
            String startingCity,String destinationCity,String category);

    List<ResponseTourDTO> filterTours(
            String tourName,LocalDate startDate,LocalDate endDate,Double price,
            String startingCity,String destinationCity,String category);
}
