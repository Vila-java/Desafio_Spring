package com.spring_desafio.services;

import com.spring_desafio.dto.ProductDTO;
import com.spring_desafio.models.ProductModel;


import java.util.List;

public interface ProductService {
    List<ProductDTO> getProductsByCategory(List<ProductDTO> productDTOList, String category);
    List<ProductDTO> getProductsByFreeShipping(List<ProductDTO> productDTOList, Boolean freeShipping);
    List<ProductDTO> getProductsByPrestige(List<ProductDTO> productDTOList, String prestige);
    List<ProductDTO> getProducts();
    List<ProductDTO> createProducts(List<ProductModel> productsList);
}
