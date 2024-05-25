package com.example.travelAgency.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
//hi

@Entity
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TOUR")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false)
    private Long id;

    @Column(name="TOUR_NAME",nullable = false)
    private String tourName;

    @Column(name="START_DATE", nullable = false)
    private LocalDate startDate;

    @Column(name="END_DATE", nullable = false)
    private LocalDate endDate;

    @Column(name="PRICE",nullable = false)
    private Double price;

    @Column(name = "STARTING_CITY")
    private String startingCity;

    @Column(name = "DESTINATION_CITY")
    private String destinationCity;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "TOUR_ID")
    private List<Reviews> reviews;




}

