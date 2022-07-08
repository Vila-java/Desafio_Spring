package com.spring_desafio.repositories;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.spring_desafio.exception.ClientAlreadyExistsException;
import com.spring_desafio.exception.InvalidServerException;
import com.spring_desafio.models.ClientModel;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe ClientRepository, responsável por manipular arquivos.
 * @author Bianca Schmitt
 * @author Bianca Polegatti
 * @author Evelin Rodrigues
 * @author Matheus Roberto
 * @author Samantha Leal
 * @author Weslley Rocha
 */
@Repository
public class ClientRepository {
    private final String LINK_FILE = "src/main/resources/data/clients.json";

    public List<ClientModel> getClients() {
        ObjectMapper mapper = new ObjectMapper();
        List<ClientModel> clientModelList = null;

        try {
            clientModelList = Arrays.asList
                    (mapper.readValue(new File(LINK_FILE), ClientModel[].class));
        } catch (Exception ex) {
            throw new InvalidServerException("Internal  server error");
        }

        return clientModelList;
    }

    public Boolean idExists(Long productId) {
        List<ClientModel> productsList = this.getClients();
        ClientModel product = productsList.stream()
                .filter(p -> p.getClientId().equals(productId))
                .findAny().orElse(null);
        if(product == null) {
            return false;
        } else {
            return true;
        }
    }

    public void createClients (List<ClientModel> newClientsList){
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        List<ClientModel> clientList = null;

        try {
            clientList = Arrays.asList(mapper.readValue(new File(LINK_FILE), ClientModel[].class));
            newClientsList.forEach(c -> {
                if(this.idExists(c.getClientId())) {
                    throw new ClientAlreadyExistsException("Client already exists!");
                }
            });

            List<ClientModel> copyList = new ArrayList<>(clientList);
            copyList.addAll(newClientsList);
            writer.writeValue(new File(LINK_FILE), copyList);
        } catch(ClientAlreadyExistsException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new InvalidServerException("Internal server error");
        }
    }
}
