package com.productApi.controller.base;

import com.productApi.model.Customers;
import com.productApi.model.User;
import com.productApi.repo.CustomerRepository;
import com.productApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/")
public class BaseController {
    @Autowired
    CustomerRepository repository;

    @GetMapping("/index")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @GetMapping("/product")
    public ModelAndView product() {
        return new ModelAndView("product/product");
    }
    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @GetMapping("/customer")
    public ModelAndView customer() {
        List<Customers> customers = (List<Customers>) repository.findAll();
        return new ModelAndView("customer/customer");
    }

    @GetMapping("/dang-ky")
    public ModelAndView dangky() {
        User user = new User();
        ModelAndView modelAndView = new ModelAndView("user/register");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @Autowired
    private UserService userService;

    @PostMapping("/user/save")
    public ModelAndView save(@ModelAttribute User user) {
        userService.save(user);

        ModelAndView modelAndView = new ModelAndView("redirect:/login");

        return modelAndView;
    }
}
