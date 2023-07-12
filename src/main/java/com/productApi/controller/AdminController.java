package com.productApi.controller;

import com.productApi.model.Role;
import com.productApi.model.User;
import com.productApi.service.RoleService;
import com.productApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @GetMapping
    public ModelAndView admin(){
        return new ModelAndView("/admin/admin");
    }

    @GetMapping("/create-role")
    public ModelAndView createRoleView() {
        Role role = new Role();
        return new ModelAndView("admin/CreateRole", "role", role);
    }

    @PostMapping("/create-role")
    public ModelAndView createRole(@ModelAttribute Role role) {
        try {
            roleService.saveRole(role);
        } catch (Exception e) {
            return new ModelAndView("redirect:/create-role");

        }
        return new ModelAndView("redirect:/index");
    }
}
