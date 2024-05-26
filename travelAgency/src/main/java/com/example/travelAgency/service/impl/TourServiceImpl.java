package com.example.travelAgency.service.impl;

import com.example.travelAgency.dto.tourDTOs.RequestTourDTO;
import com.example.travelAgency.dto.tourDTOs.ResponseTourDTO;
import com.example.travelAgency.entity.Category;
import com.example.travelAgency.entity.Tour;
import com.example.travelAgency.mappers.TourMapper;
import com.example.travelAgency.repository.CategoryRepository;
import com.example.travelAgency.repository.TourRepository;
import com.example.travelAgency.service.TourService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TourServiceImpl implements TourService {

    private final TourRepository tourRepository;
    private final CategoryRepository categoryRepository;
    private TourMapper tourMapper;

//    public TourServiceImpl(TourRepository tourRepository, CategoryRepository categoryRepository, TourMapper tourMapper) {
//        this.tourRepository = tourRepository;
//        this.categoryRepository = categoryRepository;
//        this.tourMapper = tourMapper;
//    }


    @Override
    public List<ResponseTourDTO> getAllTours() {
        List<Tour> tours = tourRepository.findAll();
        List<ResponseTourDTO> responseTourDTOS = new ArrayList<>();
        for (Tour tour:tours){
            responseTourDTOS.add(tourMapper.mapToTourDTO(tour));
        }
        return responseTourDTOS;
    }

    @Override
    public ResponseTourDTO getTourById(Long id) {
        Tour foundTour = tourRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Tour with id:"+id+" could not be found")
        );
        return tourMapper.mapToTourDTO(foundTour);
    }

    @Override
    public ResponseTourDTO addTour(RequestTourDTO requestTourDTO) {
        Category foundCategory = categoryRepository.findById(requestTourDTO.getCategoryId()).orElseThrow(
                () -> new RuntimeException("Category with id: " + requestTourDTO.getCategoryId() + " was not found!"));
        Tour tour = tourMapper.mapToTourEntity(requestTourDTO);
        tour.setCategory(foundCategory);
        Tour savedTour = tourRepository.save(tour);
        return tourMapper.mapToTourDTO(savedTour);
    }

    @Override
    public ResponseTourDTO updateTour(RequestTourDTO requestTourDTO, Long id) {
        Category foundCategory = categoryRepository.findById(requestTourDTO.getCategoryId()).orElseThrow(
                () -> new RuntimeException("Category with id: " + requestTourDTO.getCategoryId() + " was not found!"));
        Tour foundTour = tourRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Tour with id:"+id+" could not be found")
        );
        foundTour.setTourId(id);
        foundTour.setTourName(requestTourDTO.getTourName());
        foundTour.setPrice(requestTourDTO.getPrice());
        foundTour.setStartDate(requestTourDTO.getStartDate());
        foundTour.setEndDate(requestTourDTO.getEndDate());
        foundTour.setStartingCity(requestTourDTO.getStartingCity());
        foundTour.setDestinationCity(requestTourDTO.getDestinationCity());
        foundTour.setCategory(foundCategory);

        Tour savedTour = tourRepository.save(foundTour);
        return tourMapper.mapToTourDTO(savedTour);
    }

    @Override
    public void deleteTour(Long id) {
        Tour foundTour = tourRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Tour with id:"+id+" could not be found")
        );
        tourRepository.delete(foundTour);
    }

    @Override
    public List<ResponseTourDTO> searchTours(String tourName, LocalDate startDate, LocalDate endDate, Double price, String startingCity, String destinationCity, String category) {
        List<Tour> tours = new ArrayList<>();
        tours.addAll(tourRepository.findByTourName(tourName));
        tours.addAll(tourRepository.findByPrice(price));
        tours.addAll(tourRepository.findByStartingCityAndDestinationCity(startingCity, destinationCity));
        tours.addAll(tourRepository.findByCategoryName(category));
        tours.addAll(tourRepository.findByStartDateBetween(startDate, endDate));
        Set<Tour> uniqueTours = new HashSet<>(tours);
        return uniqueTours.stream().map(tourMapper::mapToTourDTO).collect(Collectors.toList());

    }

    @Override
    public List<ResponseTourDTO> filterTours(String tourName, LocalDate startDate, LocalDate endDate, Double price, String startingCity, String destinationCity, String category) {
        List<Tour> tours = tourRepository.findAll();

        List<ResponseTourDTO> filteredTours = tours.stream()
                .filter(tour -> (tourName == null || tour.getTourName()
                            .contains(tourName))
                        && (startDate == null || (tour.getStartDate() != null &&
                            !tour.getStartDate().isBefore(startDate)))
                        && (endDate == null || (tour.getEndDate() != null &&
                            !tour.getEndDate().isAfter(endDate)))
                        && (price == null || tour.getPrice().equals(price))
                        && (startingCity == null || tour.getStartingCity()
                            .contains(startingCity))
                        && (destinationCity == null || tour.getDestinationCity()
                            .contains(destinationCity))
                        && (category == null || (tour.getCategory() != null &&
                            tour.getCategory().getCategoryName().contains(category))))
                .map(tourMapper::mapToTourDTO)
                .collect(Collectors.toList());

        return filteredTours;
    }
}
