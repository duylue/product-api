package com.productApi.service.impl;

import com.productApi.model.User;
import com.productApi.repo.UserRepository;
import com.productApi.response.BaseResponse;
import com.productApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseResponse implements UserService {
    @Autowired
    UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findByUsername(String username) {
        User user = repository.findByUsername(username);
        return user;
    }

    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }
}
