package com.spring_desafio.dto;

import com.spring_desafio.models.ProductModel;
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

	public ProductDTO(ProductModel product) {
		this.name = product.getName();
		this.category = product.getCategory();
		this.prestige = product.getPrestige();
		this.brand = product.getBrand();
		this.quantity = product.getQuantity();
		this.freeShipping = product.isFreeShipping();
		this.price = product.getPrice();
	}
}
