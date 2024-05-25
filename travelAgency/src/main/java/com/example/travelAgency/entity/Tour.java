package com.example.travelAgency.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
//hi

@Entity
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Tour")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false)
    private Long id;
    @Column(name="Tour Name",nullable = false)
    private String tourName;
    @ManyToOne
    @JoinColumn(name = "category_Id")
    private Category categoryId;
    @Column(name="Start Date", nullable = false)
    private LocalDate startDate;
    @Column(name="End Date", nullable = false)
    private LocalDate endDate;
    @Column(name="Price",nullable = false)
    private Double price;
    private String startingCity;
    private String endingCity;


}

