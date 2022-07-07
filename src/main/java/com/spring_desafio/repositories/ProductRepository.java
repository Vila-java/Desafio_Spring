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

    public List<ProductModel> getAllProducts() {
        ObjectMapper mapper = new ObjectMapper();
        List<ProductModel> productModelList = null;

        try {
            productModelList = Arrays.asList
                    (mapper.readValue(new File(LINK_FILE), ProductModel[].class));
        } catch (Exception ex) {
            System.out.println("Error in the file " + LINK_FILE);
        }

        return productModelList;

    }
}
