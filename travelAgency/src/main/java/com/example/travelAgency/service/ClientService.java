package com.example.travelAgency.service;

import com.example.travelAgency.dto.clientDTOs.RequestClientDTO;
import com.example.travelAgency.dto.clientDTOs.ResponseClientDTO;

import java.util.List;

public interface ClientService {
    ResponseClientDTO saveClient(RequestClientDTO requestClientDTO);
//    ResponseClientDTO addTourToClient(Long tourId,Long clientId);
    ResponseClientDTO findClientById(Long id);
    List<ResponseClientDTO> findAllClients();
    ResponseClientDTO updateClient(Long id, RequestClientDTO requestClientDTO);
    void deleteClientById(Long id);
}
