package com.example.travelAgency.service.impl;

import com.example.travelAgency.constraint.MessageConstraint;
import com.example.travelAgency.dto.clientDTOs.RequestClientDTO;
import com.example.travelAgency.dto.clientDTOs.ResponseClientDTO;
import com.example.travelAgency.entity.Client;
import com.example.travelAgency.entity.Tour;
import com.example.travelAgency.mappers.ClientMapper;
import com.example.travelAgency.repository.ClientRepository;
import com.example.travelAgency.repository.TourRepository;
import com.example.travelAgency.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final TourRepository tourRepository;

    @Override
    public ResponseClientDTO saveClient(RequestClientDTO requestClientDTO) {

        Client clientEntity = clientMapper.mapToClient(requestClientDTO);

        Client savedClient = clientRepository.save(clientEntity);

        return clientMapper.mapToResponseClientDto(savedClient);
    }

//    @Override
//    public ResponseClientDTO addTourToClient(Long tourId,Long clientId) {
//        Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client does not exist"));
//        Tour tour = tourRepository.findById(tourId).orElseThrow(()->new RuntimeException("Tour does not exist"));
//
//        client.setTours(Collections.singleton(tour));
//        Client save = clientRepository.save(client);
//        return clientMapper.mapToResponseClientDto(save);
//
//    }


    @Override
    public ResponseClientDTO findClientById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException(MessageConstraint.CLIENT_NOT_FOUND));
        return clientMapper.mapToResponseClientDto(client);
    }

    @Override
    public List<ResponseClientDTO> findAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(clientMapper::mapToResponseClientDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseClientDTO updateClient(Long id, RequestClientDTO requestClientDTO) {
        Client clientEntity = clientRepository.findById(id).orElseThrow(() -> new RuntimeException(MessageConstraint.CLIENT_NOT_FOUND));
        clientEntity.setClientName(requestClientDTO.getClientName());
        clientEntity.setPhoneNumber(requestClientDTO.getPhoneNumber());


        Client savedClient = clientRepository.save(clientEntity);
        return clientMapper.mapToResponseClientDto(savedClient);
    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }
}
