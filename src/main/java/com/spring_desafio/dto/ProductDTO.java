package com.spring_desafio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

	private String name, category, prestige, brand;
	private Integer quantity;
	private boolean freeShipping;
	private double price;

	public ProductDTO(ProductDTO productDTO) {
		this.name = productDTO.getName();
		this.category = productDTO.getCategory();
		this.prestige = productDTO.getPrestige();
		this.brand = productDTO.getBrand();
		this.quantity = productDTO.getQuantity();
		this.freeShipping = productDTO.isFreeShipping();
		this.price = productDTO.getPrice();
	}
}
