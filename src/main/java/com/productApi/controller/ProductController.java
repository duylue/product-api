package com.productApi.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.productApi.model.Product;
import com.productApi.model.ProductSaleDTO;
import com.productApi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/pro-api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll(@RequestHeader String username,
                                    @RequestHeader String sessionId) {
        System.out.println(username);
        return ResponseEntity.ok("Thanh Cong roi").status(200).body(productService.getAll());


    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Product product) {
        productService.save(product);
        return ResponseEntity.ok(HttpStatus.OK).status(200).body("Thanh Cong");


    }

    @GetMapping("/getInfoSaleProduct")
    public ResponseEntity<?> getInfoSaleProduct() {
        List<Map<String, Objects>> maps = productService.getInfoSaleProduct();
        ObjectMapper mapper = new ObjectMapper();
        List<ProductSaleDTO> dto = new ArrayList<>();
        for (Map<String, Objects> m : maps
        ) {
            ProductSaleDTO product = mapper.convertValue(m,ProductSaleDTO.class);
            dto.add(product);
        }
        return ResponseEntity.ok(HttpStatus.OK).status(200).body(dto);


    }


}
