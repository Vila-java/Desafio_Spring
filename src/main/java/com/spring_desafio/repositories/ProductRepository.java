package com.spring_desafio.repositories;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.spring_desafio.exception.InvalidServerException;
import com.spring_desafio.models.ProductModel;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {

    private final String LINK_FILE = "src/main/resources/data/products.json";

    public List<ProductModel> getProducts() {
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

    public void createProducts (List<ProductModel> newProductsList){
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        List<ProductModel> productList = null;

        try {
            productList = Arrays.asList(mapper.readValue(new File(LINK_FILE), ProductModel[].class));
            List<ProductModel> copyList = new ArrayList<>(productList);
            copyList.addAll(newProductsList);
            writer.writeValue(new File(LINK_FILE), copyList);
        } catch (Exception ex) {

        }
        throw new InvalidServerException("Internal  server error");
   }
}
