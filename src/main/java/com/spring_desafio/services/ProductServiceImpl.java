package com.spring_desafio.services;

import com.spring_desafio.dto.ProductDTO;
import com.spring_desafio.dto.ProductRequestDTO;
import com.spring_desafio.exception.NotFoundException;
import com.spring_desafio.models.ProductModel;
import com.spring_desafio.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

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
        if (category != null) {
            return productDTOList.stream()
                    .filter(p -> p.getCategory().equalsIgnoreCase(category))
                    .collect(Collectors.toList());
        } else {
            return productDTOList;
        }
    }

    @Override
    public List<ProductDTO> getProductsByFreeShipping(List<ProductDTO> productDTOList, Boolean freeShipping) {
        if (freeShipping != null) {
            return productDTOList.stream()
                    .filter((p) -> freeShipping.equals(p.isFreeShipping()))
                    .collect(Collectors.toList());
        } else {
            return productDTOList;
        }
    }

    @Override
    public List<ProductDTO> getProductsByPrestige(List<ProductDTO> productDTOList, String prestige) {
        if (prestige != null) {
            return productDTOList.stream()
                    .filter(p -> p.getPrestige().equalsIgnoreCase(prestige))
                    .collect(Collectors.toList());
        } else {
            return productDTOList;
        }
    }

    @Override
    public List<ProductDTO> chooseOrder(List<ProductDTO> productList, Integer order) {
        if (order != null) {
            switch (order) {
                case 0:
                    return this.orderAscByName(productList);
                case 1:
                    return this.orderDescByName(productList);
                case 2:
                    return this.orderAscByValue(productList);
                case 3:
                    return this.orderDescByValue(productList);
            }
        }
        return productList;
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
                .sorted(Comparator.comparing(ProductDTO::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> orderDescByValue(List<ProductDTO> productList) {
        return productList.stream()
                .sorted(Comparator.comparing(ProductDTO::getPrice).reversed())
                .sorted((product1, product2) -> product1.getPrice() >= product2.getPrice() ? -1 : 1)
                .collect(Collectors.toList());
    }

    @Override
    public ProductModel findById(Long productId) {
        try {
            List<ProductModel> productsList = productRepository.getProducts();
            ProductModel product = productsList.stream()
                    .filter(p -> p.getProductId().equals(productId))
                    .findAny().orElse(null);
            return product;

        } catch (NullPointerException e) {
            throw new NotFoundException("Not found");
        }
    }

    @Override
    public double totalValue(List<ProductRequestDTO> productsRequestList) {
        double total = 0;
        try {
            total = productsRequestList
                    .stream()
                    .mapToDouble(p -> this.findById(p.getProductId()).getPrice() * p.getQuantity())
                    .sum();
        } catch (NotFoundException ex) {
            throw ex;
        }
        return total;
    }

    @Override
    public List<ProductDTO> createProducts(List<ProductModel> productsList) {
        productRepository.createProducts(productsList);
        return productsList.stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }

}