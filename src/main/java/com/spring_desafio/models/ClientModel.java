package com.spring_desafio.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
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
public class ClientModel {

	private Long clientId;
	private String name, phoneNumber, emailAddress;

}
