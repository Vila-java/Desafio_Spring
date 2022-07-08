package com.spring_desafio.controllers;

import com.spring_desafio.dto.ProductDTO;
import com.spring_desafio.dto.ProductRequestDTO;
import com.spring_desafio.models.ProductModel;
import com.spring_desafio.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/articles")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

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

    @PostMapping
    public ResponseEntity<List<ProductDTO>> createProducts(@RequestBody List<ProductModel> newProductsList) {
        List<ProductDTO> productDTOList = productService.createProducts(newProductsList);
        return ResponseEntity.ok(productDTOList);
    }

    @PostMapping("/totalValue")
    public ResponseEntity<Double> totalValue(@RequestBody List<ProductRequestDTO> productsRequestList) {
        double total = productService.totalValue(productsRequestList);
        return ResponseEntity.ok(total);
    }
}

