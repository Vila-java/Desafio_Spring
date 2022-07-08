package com.spring_desafio.services;

import com.spring_desafio.dto.ProductDTO;
import com.spring_desafio.dto.ProductRequestDTO;
import com.spring_desafio.models.ProductModel;

import java.util.List;

/**
 * The interface Product service.
 * @author Bianca Schmitt
 * @author Bianca Polegatti
 * @author Evelin Rodrigues
 * @author Matheus Roberto
 * @author Samantha Leal
 * @author Weslley Rocha
 */
public interface ProductService {
    /**
     * Gets products by category.
     *
     * @param productDTOList lista de produtos
     * @param category       categoria
     * @return Produtos filtrados por categoria
     */
    List<ProductDTO> getProductsByCategory(List<ProductDTO> productDTOList, String category);

    /**
     * Gets products by free shipping.
     *
     * @param productDTOList lista de produtos
     * @param freeShipping   frete gratis
     * @return Produtos filtrados por frete gratis
     */
    List<ProductDTO> getProductsByFreeShipping(List<ProductDTO> productDTOList, Boolean freeShipping);

    /**
     * Gets products by prestige.
     *
     * @param productDTOList lista de produtos
     * @param prestige       avaliaçao
     * @return Produtos filtrados por avaliaçao
     */
    List<ProductDTO> getProductsByPrestige(List<ProductDTO> productDTOList, String prestige);

    /**
     * Gets products.
     *
     * @return Lista de todos os produtos
     */
    List<ProductDTO> getProducts();

    /**
     * Create products list.
     *
     * @param productsList Lista de produtos
     * @return Cria uma nova lista de produtos
     */
    List<ProductDTO> createProducts(List<ProductModel> productsList);

    /**
     * Choose order list.
     *
     * @param productList lista de produtos
     * @param order       ordem: 0, 1, 2 e 3
     * @return Lista de todos os produtos por ordem alfabética e valor de produto,
     * crescente e decrescente
     */
    List<ProductDTO> chooseOrder(List<ProductDTO> productList, Integer order);

    /**
     * Order asc by name list.
     *
     * @param productList lista de produtos
     * @return Lista de produtos por ordem alfabetica crescente
     */
    List<ProductDTO> orderAscByName(List<ProductDTO> productList);

    /**
     * Order desc by name list.
     *
     * @param productList lista de produtos
     * @return Lista de produtos por ordem alfabetica decrescente
     */
    List<ProductDTO> orderDescByName(List<ProductDTO> productList);

    /**
     * Order asc by value list.
     *
     * @param productList lista de produtos
     * @return Lista de produtos por ordem de valor crescente
     */
    List<ProductDTO> orderAscByValue(List<ProductDTO> productList);

    /**
     * Order desc by value list.
     *
     * @param productList lista de produtos
     * @return Lista de produtos por ordem de valor decrescente
     */
    List<ProductDTO> orderDescByValue(List<ProductDTO> productList);

    /**
     * Total value double.
     *
     * @param productsRequestList lista de produtos do pedido de compras
     * @return Valor total dos produtos
     */
    double totalValue(List<ProductRequestDTO> productsRequestList);

    /**
     * Find by id product model.
     *
     * @param productId id dos produtos
     * @return Lista de produtos por id
     */
    ProductModel findById(Long productId);
}
