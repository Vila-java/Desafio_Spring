package com.spring_desafio.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientModel <T>{
	private Long clientId;
	private String name, phoneNumber, emailAddress, state;
}
