package com.example.travelAgency.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "STAFF")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long staffId;

    @Column(name = "STAFF_NAME",nullable = false)
    private String staffName;

    @Column(name = "PHONE_NUMBER",nullable = false)
    private String phoneNumber;

    @Column(name = "EXCPERIENCE")
    private Long experienceYears;
}
