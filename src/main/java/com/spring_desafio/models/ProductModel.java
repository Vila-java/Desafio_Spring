package com.spring_desafio.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {

	private long productId;
	private String name, category, prestige, brand;
	private Integer quantity;
	private boolean freeShipping;
	private double price;


}
