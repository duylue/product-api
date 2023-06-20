package com.productApi.service;


import com.productApi.model.Product;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface ProductService {
    List<Product> getAll();
    void save(Product product);

}
