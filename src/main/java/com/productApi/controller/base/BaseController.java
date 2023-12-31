package com.productApi.controller.base;

import com.productApi.model.Customers;
import com.productApi.model.Role;
import com.productApi.model.User;
import com.productApi.repo.CustomerRepository;
import com.productApi.service.RoleService;
import com.productApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class BaseController {
    @Autowired
    CustomerRepository repository;
    @Autowired
    UserService userService;


    @Autowired
    private RoleService roleService;
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/index")
    public ModelAndView home() {
        Optional<Customers> customers = customerRepository.findById(1);
        Customers customers1 = customers.get();
        Date birthday = customers1.getBirthday();
        ModelAndView modelAndView = new ModelAndView("index","cus",customers1);
        modelAndView.addObject("birthday",birthday);
//        User user = new User();
//        user.setPassword("admin");
//        user.setName("admin");
//        user.setUsername("admin");
//        Role role = new Role();
//        role.setName("ROLE_ADMIN");
//        List<Role> roles = new ArrayList<>();
//        List<User> users = new ArrayList<>();
//        roles.add(role);
//        users.add(user);
//        user.setRoles(roles);
//        role.setUsers(users);
//        userService.save(user);

        return modelAndView;
    }

    @GetMapping("/product")
    public ModelAndView product() {
        return new ModelAndView("product/product");
    }

    @GetMapping("/error-fob")
    public ModelAndView error403() {
        return new ModelAndView("error403");
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


    @PostMapping("/user/save")
    public ModelAndView save(@ModelAttribute User user) {
        userService.save(user);

        ModelAndView modelAndView = new ModelAndView("redirect:/login");

        return modelAndView;
    }
}
