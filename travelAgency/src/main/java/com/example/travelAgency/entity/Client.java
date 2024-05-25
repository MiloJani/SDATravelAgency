package com.example.travelAgency.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "CLIENT_ID")
    private Long clientId;

    @Column(name = "CLIENT_NAME",nullable = false)
    private String clientName;

    @Column(name = "PHONE_NUMBER",nullable = false)
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENT_ID")
    private List<Reviews> reviews;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "CLIENT_TOURS",
            joinColumns = @JoinColumn(name = "CLIENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "TOUR_ID")
    )
    private Set<Tour> tours;
}
