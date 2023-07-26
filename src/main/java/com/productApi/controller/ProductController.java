package com.productApi.controller;


import com.productApi.model.Product;
import com.productApi.model.ProductDTO;
import com.productApi.repo.CategoryRepo;
import com.productApi.repo.ProductRepo;
import com.productApi.response.BaseResponse;
import com.productApi.service.CategoryService;
import com.productApi.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin("*")
@RequestMapping("/pro-api")
public class ProductController {
    Logger logger = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/get-all")
    public ResponseEntity<?> getAll() {
        logger.info("---getAll---");
        return productService.getAll();

    }
    @GetMapping("/test")
    public ResponseEntity<?> test(@RequestParam String name) {
        logger.info("---getAll---");
        return productService.sortP(name);

    }
    @GetMapping("/get-list-category")
    public ResponseEntity<?> getAllCategory() {
        logger.info("---getAllCategory---");
        return categoryService.getAll();

    }
    @GetMapping("/page-product-list")
    public ResponseEntity<?> getAllProduct(@RequestParam("page")int page,
                                           @RequestParam("size")int size) {

        logger.info("---getAllProduct---");
;
        return productService.getAll(page,size);

    }
    @GetMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id") int id) {
        return productService.delete(id);

    }
    @GetMapping("/get-product-by-id")
    public ResponseEntity<?> productById(@RequestParam("id") int id) {
        return productService.getProductDTOByID(id);

    }
    @GetMapping("/get-em-sales")
    public ResponseEntity<?> getEmSales() {
        return productService.getEmSales();

    }
    @GetMapping("/get-sum-sales")
    public ResponseEntity<?> getSUmSales(@RequestParam("pid")int pid) {
        return productService.getSumSales(pid);

    }

    @GetMapping("/get-product-list")
    public ResponseEntity<?> getProductDTOList() {
        return productService.getProductDTOList();

    }


    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Product product) {

        return productService.save(product);

    }




}
