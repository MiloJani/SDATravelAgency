package com.example.travelAgency.service;

import com.example.travelAgency.entity.Category;
import com.example.travelAgency.entity.Tour;

import java.util.List;

public interface TourService {
    List<Tour> getAllTours();

    Tour getTourById(Long id) ;

    Tour addTour(Tour tour) ;

    Tour updateTour(Tour tour, Long id) ;

    Long deleteTour(Long id) ;
}
