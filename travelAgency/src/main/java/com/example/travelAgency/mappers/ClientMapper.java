package com.example.travelAgency.mappers;

import com.example.travelAgency.dto.clientDTOs.RequestClientDTO;
import com.example.travelAgency.dto.clientDTOs.ResponseClientDTO;
import com.example.travelAgency.dto.tourDTOs.ResponseTourDTO;
import com.example.travelAgency.entity.Client;
import com.example.travelAgency.entity.Tour;
import com.example.travelAgency.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ClientMapper {

    @Autowired
    private TourRepository tourRepository;

    public Client mapToClient(RequestClientDTO requestClientDTO) {
        Set<Tour> tours = requestClientDTO.getTourIds().stream()
                .map(id -> tourRepository.findById(id).orElseThrow(() -> new RuntimeException("Tour not found")))
                .collect(Collectors.toSet());

        return Client.builder()
                .clientName(requestClientDTO.getClientName())
                .phoneNumber(requestClientDTO.getPhoneNumber())
                .tours(tours)
                .build();
    }

    public ResponseClientDTO mapToResponseClientDto(Client client) {
        Set<ResponseTourDTO> tourDTOs = client.getTours().stream()
                .map(tour -> ResponseTourDTO.builder()
                        .tourId(tour.getTourId())
                        .tourName(tour.getTourName())
                        .startDate(tour.getStartDate())
                        .endDate(tour.getEndDate())
                        .price(tour.getPrice())
                        .startingCity(tour.getStartingCity())
                        .destinationCity(tour.getDestinationCity())
                        .build())
                .collect(Collectors.toSet());

        return ResponseClientDTO.builder()
                .clientId(client.getClientId())
                .clientName(client.getClientName())
                .phoneNumber(client.getPhoneNumber())
                .tours(tourDTOs)
                .build();
    }
}

