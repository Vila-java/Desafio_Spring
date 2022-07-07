package com.spring_desafio.services;

import com.spring_desafio.dto.ProductDTO;
import com.spring_desafio.models.ProductModel;


import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProductsByCategory(String category);
    List<ProductDTO> getAllProductsByFreeShipping(Boolean freeShipping);
    List<ProductDTO> getAllProductsByCaterogyAndFreeShipping(String category,Boolean freeShipping);
    List<ProductDTO> getAllProducts();
    List<ProductDTO> createProducts(List<ProductModel> productsList);
    List<ProductDTO> getAllProductsByPrestige(String prestige);
    List<ProductDTO> getAllProductsByFreeShippingAndPrestige(Boolean freeShipping, String prestige);
}
