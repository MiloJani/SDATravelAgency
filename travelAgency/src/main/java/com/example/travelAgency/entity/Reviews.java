package com.example.travelAgency.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REVIEW_ID")
    private Long reviewId;

    @Column(name = "DECRIPTION")
    private String description;

    @Email
    @Column(name = "EMAIL")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TOUR_ID",nullable = false)
    private Tour tour;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "CLIENT_ID",nullable = false)
//    private Client client;

}

