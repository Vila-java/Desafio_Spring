package com.spring_desafio.dto;

import com.spring_desafio.models.OrderModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description Classe OrderDTO,
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
public class OrderDTO {

	private String name, state, postalCode, country;
	private List<Long> listId;

	/**
	 * Instantiates a new Order dto.
	 *
	 * @param orderModel the order model
	 */
	public OrderDTO(OrderModel orderModel) {
		this.name = orderModel.getName();
		this.state = orderModel.getState();
		this.postalCode = orderModel.getPostalCode();
		this.country = orderModel.getCountry();
	}
}
