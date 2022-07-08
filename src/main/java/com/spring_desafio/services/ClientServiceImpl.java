package com.spring_desafio.services;

import com.spring_desafio.dto.ClientDTO;
import com.spring_desafio.models.ClientModel;
import com.spring_desafio.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<ClientDTO> getClients() {
        List<ClientDTO> clientList = clientRepository
                .getClients()
                .stream()
                .map(ClientDTO::new)
                .collect(Collectors.toList());
        return clientList;
    }

    @Override
    public List<ClientDTO> getClientsByState(List<ClientDTO> clientDTOList, String state) {
        if (state != null) {
            return clientDTOList.stream()
                    .filter(p -> p.getState().equalsIgnoreCase(state))
                    .collect(Collectors.toList());
        } else {
            return clientDTOList;
        }
    }

    @Override
    public List<ClientDTO> createClients(List<ClientModel> clientList) {
        clientRepository.createClients(clientList);
        return clientList.stream()
                .map(ClientDTO::new)
                .collect(Collectors.toList());
    }
}
