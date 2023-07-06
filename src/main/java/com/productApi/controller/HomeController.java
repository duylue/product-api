package com.productApi.controller;

import com.productApi.model.User;
import com.productApi.model.UserDto;
import com.productApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
@RequestMapping
public class HomeController {
    @GetMapping("/index")
    public String home() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        // create model object to store form data
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    @Autowired
    UserService userService;
    @GetMapping("/users")
    public String users(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
    @GetMapping("/users/product")
    public String product(Model model){

        return "product";
    }
    @GetMapping("/users/em")
    public String em(Model model){

        return "employee";
    }
    @GetMapping("/admin")
    public String admin(Model model){
        return "admin";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/register/save")
    public String registration(@ModelAttribute("user") UserDto userDto,

                               Model model) {
        try {
            User existingUser = userService.findUserByEmail(userDto.getEmail());
            if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
                return "/register";
            }
            userService.saveUser(userDto);
            return "redirect:/index";
        } catch (Exception e) {
            return "/register";
        }

    }
    }
