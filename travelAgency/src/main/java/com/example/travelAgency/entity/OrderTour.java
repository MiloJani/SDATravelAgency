package com.example.travelAgency.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ORDER_TOUR")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderTour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TOUR_ID")
    private Tour tour;


}

