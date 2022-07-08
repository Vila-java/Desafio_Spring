package com.spring_desafio.dto;

import com.spring_desafio.models.ClientModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description Classe ClientDTO, Endpoint de requisição de compras.
 * @author Bianca Schmitt
 * @author Bianca Polegatti
 * @author Evelin Rodrigues
 * @author Matheus Roberto
 * @author Samantha Leal
 * @author Weslley Rocha
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

	private String name, phoneNumber, emailAddress;

	/**
	 * Instantiates a new Client dto.
	 *
	 * @param clientModel Construtor que transforma o objeto ClientModel em ClientDTO.
	 */
	public ClientDTO(ClientModel clientModel) {
		this.name = clientModel.getName();
		this.phoneNumber = clientModel.getPhoneNumber();
		this.emailAddress = clientModel.getEmailAddress();
	}
}
