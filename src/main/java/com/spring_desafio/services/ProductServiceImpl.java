package com.spring_desafio.services;

import com.spring_desafio.dto.ProductDTO;
import com.spring_desafio.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository repo;

    @Override
    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> productList = repo.getAll().stream().map(ProductDTO::new).collect(Collectors.toList());
        return productList;
    }
}
