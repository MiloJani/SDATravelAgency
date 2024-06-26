package com.example.travelAgency.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
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
    @Column(name="TOUR_ID", updatable = false, nullable = false)
    private Long tourId;

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

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Reviews> reviews;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "TOUR_CLIENTS",
//            joinColumns = @JoinColumn(name = "TOUR_ID"),
//            inverseJoinColumns = @JoinColumn(name = "CLIENT_ID")
//    )
//    private Set<Client> clients;
}

