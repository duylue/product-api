package com.productApi.controller.base;

import com.productApi.model.Customers;
import com.productApi.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/")
public class BaseController {
    @Autowired
    CustomerRepository repository;
    @GetMapping
    public ModelAndView home (){
     return  new ModelAndView("index");
    }
    @GetMapping("/product")
    public ModelAndView product (){
        return  new ModelAndView("product/product");
    }
    @GetMapping("/customer")
    public ModelAndView customer (){
        List<Customers> customers = (List<Customers>) repository.findAll();
        return  new ModelAndView("customer/customer");
    }
}
