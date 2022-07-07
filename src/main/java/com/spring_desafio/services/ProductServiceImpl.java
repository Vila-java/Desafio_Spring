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
    public List<ProductDTO> getProducts() {
        List<ProductDTO> productList = productRepository
                .getProducts()
                .stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
        return productList;
    }

    @Override
    public List<ProductDTO> getProductsByCategory(List<ProductDTO> productDTOList, String category) {
        if(category != null) {
            return productDTOList.stream()
                    .filter(p -> p.getCategory().equalsIgnoreCase(category))
                    .collect(Collectors.toList());
        } else {
            return productDTOList;
        }
    }

    @Override
    public List<ProductDTO> getProductsByFreeShipping(List<ProductDTO> productDTOList, Boolean freeShipping) {
        if(freeShipping != null) {
            return productDTOList.stream()
                    .filter((p)-> freeShipping.equals(p.isFreeShipping()))
                    .collect(Collectors.toList());
        } else {
            return productDTOList;
        }
    }

    @Override
    public List<ProductDTO> getProductsByPrestige(List<ProductDTO> productDTOList, String prestige) {
        if(prestige != null) {
            return productDTOList.stream()
                    .filter(p -> p.getPrestige().equalsIgnoreCase(prestige))
                    .collect(Collectors.toList());
        } else {
            return productDTOList;
        }
    }

    @Override
    public List<ProductDTO> createProducts (List<ProductModel> productsList){
        productRepository.createProducts(productsList);
        return productsList.stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }
}