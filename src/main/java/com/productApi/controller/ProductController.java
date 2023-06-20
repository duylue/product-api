package com.productApi.controller;


import com.productApi.model.Product;
import com.productApi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/pro-api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll() {
        return productService.getAll();


    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Product product) {
        return productService.save(product);


    }

}
