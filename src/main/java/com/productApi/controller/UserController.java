package com.productApi.controller;

import com.productApi.service.RoleService;
import com.productApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-api")
public class UserController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @GetMapping("/get-all-user")
    public ResponseEntity<?> getUsers(){

        return userService.findAll();
    }
}
