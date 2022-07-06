package com.spring_desafio.services;

import com.spring_desafio.dto.ProductDTO;
import com.spring_desafio.models.ProductModel;
import com.spring_desafio.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDTO> getAllProductsByCategory(String category) {
        List<ProductModel> productsList = productRepository.getAllProducts();
        return productsList.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }
}

