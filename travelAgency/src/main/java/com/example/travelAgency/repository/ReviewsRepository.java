package com.example.travelAgency.repository;

import com.example.travelAgency.entity.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReviewsRepository extends JpaRepository<Reviews,Long> {

    List<Reviews> findByTourId(Long tourId);
}
