package com.example.travelAgency.repository;

import com.example.travelAgency.entity.OrderTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderTourRepository extends JpaRepository<OrderTour,Long> {
}
