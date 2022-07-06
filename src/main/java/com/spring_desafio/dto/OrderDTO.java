package com.spring_desafio.dto;

import com.spring_desafio.models.OrderModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

	private String name, state, postalCode, country;
	private List<Long> listId;

	public OrderDTO(OrderModel orderModel) {
		this.name = orderModel.getName();
		this.state = orderModel.getState();
		this.postalCode = orderModel.getPostalCode();
		this.country = orderModel.getCountry();
	}
}
