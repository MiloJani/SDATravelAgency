package com.example.travelAgency.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
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



    public Tour() {

    }

    public Tour(Long id, String tourName, Category categoryId, LocalDate startDate, LocalDate endDate, Double price, String startingCity, String endingCity) {
        this.id = id;
        this.tourName = tourName;
        this.categoryId = categoryId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.startingCity = startingCity;
        this.endingCity = endingCity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStartingCity() {
        return startingCity;
    }

    public void setStartingCity(String startingCity) {
        this.startingCity = startingCity;
    }

    public String getEndingCity() {
        return endingCity;
    }

    public void setEndingCity(String endingCity) {
        this.endingCity = endingCity;
    }
}

