package com.spring_desafio.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class ProductModel {

	private Long productId;
	private String name, category, prestige, brand;
	private Integer quantity;
	private boolean freeShipping;
	private double price;

}
