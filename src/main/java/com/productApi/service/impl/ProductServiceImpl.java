package com.productApi.service.impl;


import com.productApi.model.Product;
import com.productApi.repo.ProductRepo;
import com.productApi.response.BaseResponse;
import com.productApi.exceptionHendler.BusinessException;
import com.productApi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends BaseResponse implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Override
    public ResponseEntity<?> getAll() {

            return getResponseEntity(productRepo.findAll());


    }

    @Override
    public ResponseEntity<?> save(Product product) {
        return getResponseEntity(productRepo.save(product));
    }
}
