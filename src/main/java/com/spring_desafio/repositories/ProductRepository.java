package com.spring_desafio.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring_desafio.models.ProductModel;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {
    private final String LINK_FILE = "src/main/resources/data/products.json";

    public List<ProductModel> getAll() {

        ObjectMapper mapper = new ObjectMapper();

        List<ProductModel> productList = null;

        try {
            productList = Arrays.asList(mapper.readValue(new File(LINK_FILE), ProductModel[].class));
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return productList;

    }
}
