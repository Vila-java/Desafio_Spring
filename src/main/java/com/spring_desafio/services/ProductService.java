package com.spring_desafio.services;

import com.spring_desafio.dto.ProductDTO;
import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProductsByCategory(String category);
    List<ProductDTO> getAllProductsByFreeShipping(Boolean freeShipping);
    List<ProductDTO> getAllProductsByCaterogyAndFreeShipping(String category,Boolean freeShipping);
    List<ProductDTO> getAllProducts();
    List<ProductDTO> orderAscByName(List<ProductDTO> productList);
    List<ProductDTO> orderDescByName(List<ProductDTO> productList);
    List<ProductDTO> orderAscByValue(List<ProductDTO> productList);
    List<ProductDTO> orderDescByValue(List<ProductDTO> productList);
}
