package com.spring_desafio.services;

import com.spring_desafio.dto.ProductDTO;
import com.spring_desafio.dto.ProductRequestDTO;
import com.spring_desafio.exception.InvalidServerException;
import com.spring_desafio.exception.NotFoundException;
import com.spring_desafio.models.ProductModel;
import com.spring_desafio.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Product service.
 * Classe de implementaçao da interface productService
 *
 * @author Bianca Schmitt
 * @author Bianca Polegatti
 * @author Evelin Rodrigues
 * @author Matheus Roberto
 * @author Samantha Leal
 * @author Weslley Rocha
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     *
     * @return Lista de todos os produtos
     */
    @Override
    public List<ProductDTO> getProducts() {
        List<ProductDTO> productList = productRepository
                .getProducts()
                .stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
        return productList;
    }

    /**
     *
     * @return Lista de todos os produtos filtrados por categoria
     */
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

    /**
     *
     * @return Lista de todos os produtos filtrados por frete gratis
     */
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

    /**
     *
     * @return Lista de todos os produtos filtrados por avaliaçao
     */
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

    /**
     *
     * @return Lista de todos os produtos filtrados por ordem alfabética e valor de produto,
     * crescente e decrescente
     */
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

    /**
     *
     * @return Lista de todos os produtos filtrados por ordem alfabetica crescente
     */
    @Override
    public List<ProductDTO> orderAscByName(List<ProductDTO> productList) {
        return productList.stream()
                .sorted(Comparator.comparing(ProductDTO::getName))
                .collect(Collectors.toList());
    }

    /**
     *
     * @return Lista de todos os produtos filtrados por ordem alfabetica decrescente
     */
    @Override
    public List<ProductDTO> orderDescByName(List<ProductDTO> productList) {
        return productList.stream()
                .sorted(Comparator.comparing(ProductDTO::getName).reversed())
                .collect(Collectors.toList());
    }

    /**
     *
     * @return Lista de todos os produtos filtrados por valor crescente
     */
    @Override
    public List<ProductDTO> orderAscByValue(List<ProductDTO> productList) {
        return productList.stream()
                .sorted(Comparator.comparing(ProductDTO::getPrice))
                .collect(Collectors.toList());
    }

    /**
     *
     * @return Lista de todos os produtos filtrados por valor decrescente
     */
    @Override
    public List<ProductDTO> orderDescByValue(List<ProductDTO> productList) {
        return productList.stream()
                .sorted(Comparator.comparing(ProductDTO::getPrice).reversed())
                .sorted((product1, product2) -> product1.getPrice() >= product2.getPrice() ? -1 : 1)
                .collect(Collectors.toList());
    }

    /**
     *
     * @return Lista de todos os produtos filtrados por id do produto
     */
    @Override
    public ProductModel findById(Long productId) {
        List<ProductModel> productsList = productRepository.getProducts();
        ProductModel product = productsList.stream()
                .filter(p -> p.getProductId().equals(productId))
                .findAny().orElse(null);
        return product;
    }

    /**
     *
     * @return Lista o valor total do pedido de compras
     */
    @Override
    public double totalValue(List<ProductRequestDTO> productsRequestList) {
        double total = 0;
        try {
            total = productsRequestList
                    .stream()
                    .mapToDouble(p -> {
                        ProductModel product = this.findById(p.getProductId());
                        if (product==null) {
                            throw new NotFoundException("Not found productId");
                        } else {
                            return product.getPrice() * product.getQuantity();
                        }
                    })
                    .sum();
        } catch (NotFoundException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new InvalidServerException("Internal  server error");
        }
        return total;
    }

    /**
     *
     * @return Nova lista de produtos
     */
    @Override
    public List<ProductDTO> createProducts(List<ProductModel> productsList) {
        productRepository.createProducts(productsList);
        return productsList.stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }

}