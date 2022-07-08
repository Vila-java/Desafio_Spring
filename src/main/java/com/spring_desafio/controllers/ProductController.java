package com.spring_desafio.controllers;

import com.spring_desafio.dto.ProductDTO;
import com.spring_desafio.dto.ProductRequestDTO;
import com.spring_desafio.models.ProductModel;
import com.spring_desafio.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Classe ProductController, Endpoints de produtos.
 * @author Bianca Schmitt
 * @author Bianca Polegatti
 * @author Evelin Rodrigues
 * @author Matheus Roberto
 * @author Samantha Leal
 * @author Weslley Rocha
 */
@RequestMapping("api/v1/articles")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Gets products,
     *
     * Pegar uma lista de todos os produtos, filtrando por:
     * @param category     categoria
     * @param freeShipping frete grátis
     * @param prestige    avaliação
     * @param order       ordem: 0, 1, 2 e 3
     * @return Retorna a lista de produtos com ou sem filtro.
     */
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Boolean freeShipping,
            @RequestParam(required = false) String prestige,
            @RequestParam(required = false) Integer order
    ) {
        List<ProductDTO> list = productService.getProducts();
        list = productService.getProductsByCategory(list, category);
        list = productService.getProductsByFreeShipping(list, freeShipping);
        list = productService.getProductsByPrestige(list, prestige);
        list = productService.chooseOrder(list, order);
        return ResponseEntity.ok(list);
    }

    /**
     * Create products response entity.
     * @param newProductsList Recebe uma lista de produtos.
     * @return Retorna uma lista de produtos
     */
    @PostMapping
    public ResponseEntity<List<ProductDTO>> createProducts(@RequestBody List<ProductModel> newProductsList) {
        List<ProductDTO> productDTOList = productService.createProducts(newProductsList);
        return ResponseEntity.ok(productDTOList);
    }

    /**
     * Total value response entity.
     * @param productsRequestList Retorna o valor do total dos produtos
     * @return Retorna o valor do total dos produtos
     */
    @PostMapping("/totalValue")
    public ResponseEntity<Double> totalValue(@RequestBody List<ProductRequestDTO> productsRequestList) {
        double total = productService.totalValue(productsRequestList);
        return ResponseEntity.ok(total);
    }
}

