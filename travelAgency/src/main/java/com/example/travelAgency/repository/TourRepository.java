package com.example.travelAgency.repository;

import com.example.travelAgency.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends JpaRepository<Tour,Long> {
}
