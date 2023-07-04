package com.productApi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/")
public class HomeController {
    private static int I = 1;
    private static String STR ="A";
    @GetMapping
    public ModelAndView home(HttpSession session){
        I++;
        String username =  "adsd"+I;
        byte[] bytes = "hello".getBytes(StandardCharsets.UTF_8);
        String s = new String(bytes, StandardCharsets.UTF_8);

        session.setAttribute(username,username);
        return new ModelAndView("index");
    }
    @GetMapping("/out")
    public ModelAndView logout(HttpSession session){
        String username =  "adsd"+I;
        session.removeAttribute(username);
        return new ModelAndView("index");
    }
}
