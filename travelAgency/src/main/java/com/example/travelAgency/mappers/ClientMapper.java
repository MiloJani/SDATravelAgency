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

        return Client.builder()
                .clientName(requestClientDTO.getClientName())
                .phoneNumber(requestClientDTO.getPhoneNumber())
                .build();
    }

    public ResponseClientDTO mapToResponseClientDto(Client client) {

        return ResponseClientDTO.builder()
                .clientId(client.getClientId())
                .clientName(client.getClientName())
                .phoneNumber(client.getPhoneNumber())
                .build();
    }
}

