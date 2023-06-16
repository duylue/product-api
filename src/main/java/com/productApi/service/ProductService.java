package com.productApi.service;


import com.productApi.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ResponseEntity<?> getAll();
    ResponseEntity<?> save(Product product);
}
