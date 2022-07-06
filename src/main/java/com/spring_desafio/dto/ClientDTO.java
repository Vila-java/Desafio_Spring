package com.spring_desafio.dto;

import com.spring_desafio.models.ClientModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

	private String name, phoneNumber, emailAddress;

	public ClientDTO(ClientModel clientModel) {
		this.name = clientModel.getName();
		this.phoneNumber = clientModel.getPhoneNumber();
		this.emailAddress = clientModel.getEmailAddress();
	}
}
