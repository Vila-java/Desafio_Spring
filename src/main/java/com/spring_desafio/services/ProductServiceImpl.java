package com.spring_desafio.services;

import com.spring_desafio.dto.ProductDTO;
import com.spring_desafio.models.ProductModel;
import com.spring_desafio.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{


    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> productList = productRepository.getAllProducts().stream().map(ProductDTO::new).collect(Collectors.toList());
        return productList;
    }

    @Override
    public List<ProductDTO> getAllProductsByCategory(String category) {
        List<ProductModel> productsList = productRepository.getAllProducts();
        return productsList.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getAllProductsByFreeShipping(Boolean freeShipping) {
        List<ProductModel> productsList = productRepository.getAllProducts();
                return productsList.stream()
                            .filter((p)-> freeShipping.equals(p.isFreeShipping()))
                            .map(ProductDTO::new)
                            .collect(Collectors.toList());
                }

    @Override
    public List<ProductDTO> orderAscByName(List<ProductDTO> productList) {
        return productList.stream()
                .sorted(Comparator.comparing(ProductDTO::getName))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> orderDescByName(List<ProductDTO> productList) {
        return productList.stream()
                .sorted(Comparator.comparing(ProductDTO::getName).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> orderAscByValue(List<ProductDTO> productList) {
        return productList.stream()
                .sorted(Comparator.comparing(ProductDTO::getPrice) )
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> orderDescByValue(List<ProductDTO> productList) {
        return productList.stream()
                .sorted(Comparator.comparing(ProductDTO::getPrice).reversed() )
                .sorted((product1, product2) -> product1.getPrice() >= product2.getPrice() ? -1 : 1 )
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getAllProductsByCaterogyAndFreeShipping(String category,Boolean freeShipping) {
        List<ProductModel> productsList = productRepository.getAllProducts();
                return productsList.stream()
                            .filter((p)-> freeShipping.equals(p.isFreeShipping()) &&
                             p.getCategory().equalsIgnoreCase(category))
                            .map(ProductDTO::new)
                            .collect(Collectors.toList());
                }

}

