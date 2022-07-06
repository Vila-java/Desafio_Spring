package com.spring_desafio.controllers;

import com.spring_desafio.dto.ProductDTO;
import com.spring_desafio.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/articles")
@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(){

        List<ProductDTO> productList = service.getAllProducts();

        return ResponseEntity.ok(productList);
    }
}
