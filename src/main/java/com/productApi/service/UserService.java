package com.productApi.service;

import com.productApi.model.User;
import com.productApi.model.UserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}

