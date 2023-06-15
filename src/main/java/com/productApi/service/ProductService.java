package com.productApi.service;


import com.productApi.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    void save(Product product);
}
