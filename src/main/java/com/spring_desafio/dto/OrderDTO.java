package com.spring_desafio.dto;

import com.spring_desafio.models.OrderModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Classe OrderDTO,
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
public class OrderDTO {

	private String name, state, postalCode, country;
	private List<Long> listId;

	/**
	 * Instantiates a new Order dto.
	 *
	 * @param orderModel Construtor que transforma o objeto OrderModel em OrderDTO.
	 */
	public OrderDTO(OrderModel orderModel) {
		this.name = orderModel.getName();
		this.state = orderModel.getState();
		this.postalCode = orderModel.getPostalCode();
		this.country = orderModel.getCountry();
	}
}
