package com.spring_desafio.services;

import com.spring_desafio.dto.ProductDTO;
import com.spring_desafio.dto.ProductRequestDTO;
import com.spring_desafio.models.ProductModel;


import java.util.List;

public interface ProductService {
    List<ProductDTO> getProductsByCategory(List<ProductDTO> productDTOList, String category);
    List<ProductDTO> getProductsByFreeShipping(List<ProductDTO> productDTOList, Boolean freeShipping);
    List<ProductDTO> getProductsByPrestige(List<ProductDTO> productDTOList, String prestige);
    List<ProductDTO> getProducts();
    List<ProductDTO> createProducts(List<ProductModel> productsList);
    List<ProductDTO> chooseOrder(List<ProductDTO> productList, Integer order);
    List<ProductDTO> orderAscByName(List<ProductDTO> productList);
    List<ProductDTO> orderDescByName(List<ProductDTO> productList);
    List<ProductDTO> orderAscByValue(List<ProductDTO> productList);
    List<ProductDTO> orderDescByValue(List<ProductDTO> productList);
    double totalValue(List<ProductRequestDTO> productsRequestList);
    ProductModel findById(Long productId);
}
