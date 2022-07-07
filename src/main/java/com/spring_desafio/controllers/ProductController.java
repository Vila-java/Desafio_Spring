package com.spring_desafio.controllers;

import com.spring_desafio.dto.ProductDTO;
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

    @GetMapping("/{category}")
    public ResponseEntity<List<ProductDTO>> getAllProductsByCategory(@PathVariable String category) {
        List<ProductDTO> list = productService.getAllProductsByCategory(category);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/freeShipping/{freeShipping}")
    public ResponseEntity<List<ProductDTO>> getAllProductsByFreeShipping(@PathVariable Boolean freeShipping) {
        List<ProductDTO> list = productService.getAllProductsByFreeShipping(freeShipping);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/c/{category}/{freeShipping}")
    public ResponseEntity<List<ProductDTO>> getAllProductsByCaterogyAndFreeShipping(@PathVariable String category,
        @PathVariable Boolean freeShipping) {
        List<ProductDTO> list = productService.getAllProductsByCaterogyAndFreeShipping(category, freeShipping);
        return ResponseEntity.ok(list);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> productList = productService.getAllProducts();
        return ResponseEntity.ok(productList);

    }

    @PostMapping
    public ResponseEntity<List<ProductDTO>> createProducts(@RequestBody List<ProductModel> newProductsList) {
        List<ProductDTO> productDTOList = productService.createProducts(newProductsList);
        return ResponseEntity.ok(productDTOList);
    }

}

