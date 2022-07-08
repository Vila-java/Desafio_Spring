package com.spring_desafio.controllers;

import com.spring_desafio.dto.ClientDTO;
import com.spring_desafio.models.ClientModel;
import com.spring_desafio.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/clients")
@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getClients(
            @RequestParam(required = false) String state
    ) {
        List<ClientDTO> list = clientService.getClients();
        list = clientService.getClientsByState(list, state);
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<List<ClientDTO>> createClients(@RequestBody List<ClientModel> newClientList) {
        List<ClientDTO> productDTOList = clientService.createClients(newClientList);
        return ResponseEntity.ok(productDTOList);
    }
}
