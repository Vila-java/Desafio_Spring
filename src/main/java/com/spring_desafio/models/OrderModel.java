package com.spring_desafio.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
public class OrderModel {

	private Long orderId;
	private String name, state, postalCode, country;
	private List<Long> listId;

}
