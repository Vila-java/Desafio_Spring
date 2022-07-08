package com.spring_desafio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe que manipula o pedido de compra.
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
public class ProductRequestDTO {
    private Long productId;
    private Integer quantity;

}
