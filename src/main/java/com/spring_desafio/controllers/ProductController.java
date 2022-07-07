package com.spring_desafio.controllers;

import com.spring_desafio.dto.ProductDTO;
import com.spring_desafio.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/f/{freeShipping}/{prestige}")
    public ResponseEntity<List<ProductDTO>> getAllProductsByFreeShippingAndPrestige(@PathVariable Boolean freeShipping,
        @PathVariable String prestige){
            List<ProductDTO> list = productService.getAllProductsByFreeShippingAndPrestige(freeShipping, prestige);
            return ResponseEntity.ok(list);
    }
}

