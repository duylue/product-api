package com.productApi.service;

import com.productApi.model.User;
import com.productApi.response.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    User findByUsername(String username);
    void save(User user);
    ResponseEntity<?> findAll();





}
