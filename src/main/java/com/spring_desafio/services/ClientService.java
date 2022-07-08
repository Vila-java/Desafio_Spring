package com.spring_desafio.services;
import com.spring_desafio.dto.ClientDTO;
import com.spring_desafio.models.ClientModel;


import java.util.List;

/**
 * The interface Client service.
 *
 * @author Bianca Schmitt
 * @author Bianca Polegatti
 * @author Evelin Rodrigues
 * @author Matheus Roberto
 * @author Samantha Leal
 * @author Weslley Rocha
 */
public interface ClientService {
    List<ClientDTO> getClients();
    List<ClientDTO> getClientsByState(List<ClientDTO> clientDTOList, String state);
    List<ClientDTO> createClients(List<ClientModel> clientList);
}
