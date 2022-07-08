package com.spring_desafio.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
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
public class OrderModel {

	private Long orderId;
	private String name, state, postalCode, country;
	private List<Long> listId;

}
