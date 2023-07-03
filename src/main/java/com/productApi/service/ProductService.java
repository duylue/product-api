package com.productApi.service;


import com.productApi.model.Product;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface ProductService {

    ResponseEntity<?> getAll();
    ResponseEntity<?> getAll(int page,int size);
    ResponseEntity<?> save(Product product);

    ResponseEntity<?> delete(int id);
    ResponseEntity<?> getEmSales();
    ResponseEntity<?>getSumSales(int pid);
    ResponseEntity<?>getProductDTOList();
    ResponseEntity<?> getProductDTOByID(int id);

}
