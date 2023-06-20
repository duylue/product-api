package com.productApi.service.impl;


import com.productApi.model.Product;
import com.productApi.repo.ProductRepo;
import com.productApi.response.BaseResponse;
import com.productApi.exceptionHendler.BusinessException;
import com.productApi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

@Service
public class ProductServiceImpl extends BaseResponse implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Override
    public ResponseEntity<?> getAll() {
        try {
            logger.info("----test-----");
            return getResponseEntity(productRepo.findAll());
        } catch (Exception s) {

            throw new BusinessException(500, s.getMessage());
        }


    }

    @Override
    public ResponseEntity<?> save(Product product) {
        return getResponseEntity(productRepo.save(product));
    }
}
