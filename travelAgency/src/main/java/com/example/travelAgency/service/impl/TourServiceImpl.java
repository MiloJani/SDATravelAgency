package com.example.travelAgency.service.impl;

import com.example.travelAgency.entity.Tour;
import com.example.travelAgency.repository.TourRepository;
import com.example.travelAgency.service.TourService;

import java.util.List;
import java.util.Optional;

public class TourServiceImpl implements TourService {

    private final TourRepository tourRepository;

    public TourServiceImpl(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }


    @Override
    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    @Override
    public Tour getTourById(Long id) {
        return tourRepository.findById(id).orElse(null);
    }

    @Override
    public Tour addTour(Tour tour) {
        if (!tourRepository.existsById(tour.getTourId())){
            tourRepository.save(tour);
            return tour;
        }
       return null;
    }

    @Override
    public Tour updateTour(Tour tour, Long id) {
        Optional<Tour> tourOptional=tourRepository.findById(id);
        if(tourOptional.isPresent()){
            Tour existingTour=tourOptional.get();
            existingTour.setTourName(tour.getTourName());
            tourRepository.save(existingTour);
            return existingTour;

        }
        return null;
    }

    @Override
    public Long deleteTour(Long id) {
        Optional<Tour> tourOptional=tourRepository.findById(id);
        if(tourOptional.isPresent()) {
            Tour existingTour=tourOptional.get();
            tourRepository.delete(existingTour);
            return id;
        }
        return null;
    }
}
