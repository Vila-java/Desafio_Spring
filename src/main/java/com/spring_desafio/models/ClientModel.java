package com.spring_desafio.models;

import com.spring_desafio.exception.CannotBeNullException;
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
public class ClientModel <T>{
	private Long clientId;
	private String name, phoneNumber, emailAddress, state;

	public void validateAllFields() {
		validateField("clientId cannot be null", (T)clientId);
		validateField("name cannot be null", (T)name);
		validateField("emailAddress cannot be null", (T)emailAddress);
		validateField("phoneNumber cannot be null", (T)phoneNumber);
		validateField("state cannot be null", (T)state);
	}

	public void validateField(String msg, T object) {
		if(object == null) {
			throw new CannotBeNullException(msg);
		}
	}
}
