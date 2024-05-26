package com.example.travelAgency.repository;

import com.example.travelAgency.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour,Long> {

    List<Tour> findByTourName(String tourName);

    List<Tour> findByPrice(Double price);
    List<Tour> findByStartingCityAndDestinationCity(String startingCity,String destinationCity);

    @Query("SELECT t FROM Tour t LEFT JOIN t.category c WHERE c.categoryName LIKE %?1%")
    List<Tour> findByCategoryName(String category);

    List<Tour> findByStartDateBetween(LocalDate startDate, LocalDate endDate);
}
