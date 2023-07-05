package com.productApi.service;

import com.productApi.model.user.User;

public interface UserService {
    User findByUsername(String username);
}
