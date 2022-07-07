package com.spring_desafio.services;

import com.spring_desafio.dto.ProductDTO;
import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();
}
