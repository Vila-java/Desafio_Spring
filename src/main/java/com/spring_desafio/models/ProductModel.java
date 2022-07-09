package com.spring_desafio.models;

import com.spring_desafio.exception.CannotBeNullException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class ProductModel<T> {

	private Long productId;
	private String name, category, prestige, brand;
	private Integer quantity;
	private Boolean freeShipping;
	private Double price;

	public void validateAllFields() {
		validateField("productId cannot be null", (T)productId);
		validateField("name cannot be null", (T)name);
		validateField("category cannot be null", (T)category);
		validateField("prestige cannot be null", (T)prestige);
		validateField("brand cannot be null", (T)brand);
		validateField("quantity cannot be null", (T)quantity);
		validateField("freeShipping cannot be null", (T)freeShipping);
		validateField("price cannot be null", (T)price);
	}

	public void validateField(String msg, T object) {
		if(object == null) {
			throw new CannotBeNullException(msg);
		}
	}
}
