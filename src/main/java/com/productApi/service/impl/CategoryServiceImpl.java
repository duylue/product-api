package com.productApi.service.impl;

import com.productApi.repo.CategoryRepo;
import com.productApi.response.BaseResponse;
import com.productApi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends BaseResponse implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public ResponseEntity<?> getAll() {
        return getResponseEntity(categoryRepo.findAll());
    }
}
