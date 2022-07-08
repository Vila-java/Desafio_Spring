package com.spring_desafio.dto;

import com.spring_desafio.models.ClientModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description Classe ClientDTO, Endpoint de requisição de compras.
 * @Author Bianca Schmitt
 * @Author Bianca Polegatti
 * @Author Evelin Rodrigues
 * @Author Matheus Roberto
 * @Author Samantha Leal
 * @Author Weslley Rocha
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

	private String name, phoneNumber, emailAddress;

	/**
	 * Instantiates a new Client dto.
	 *
	 * @param clientModel the client model
	 */
	public ClientDTO(ClientModel clientModel) {
		this.name = clientModel.getName();
		this.phoneNumber = clientModel.getPhoneNumber();
		this.emailAddress = clientModel.getEmailAddress();
	}
}
