package com.spring_desafio.dto;

import com.spring_desafio.models.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description Classe ProductDTO,
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
public class ProductDTO {

	private String name, category, prestige, brand;
	private Integer quantity;
	private boolean freeShipping;
	private double price;

	/**
	 * Instantiates a new Product dto.
	 *
	 * @param productModel the product model
	 */

	public ProductDTO(ProductModel productModel) {
		this.name = productModel.getName();
		this.category = productModel.getCategory();
		this.prestige = productModel.getPrestige();
		this.brand = productModel.getBrand();
		this.quantity = productModel.getQuantity();
		this.freeShipping = productModel.isFreeShipping();
		this.price = productModel.getPrice();
	}
}
