package com.productApi.service.user;

import com.productApi.model.user.User;
import com.productApi.repo.UserRepository;
import com.productApi.response.BaseResponse;
import com.productApi.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseResponse implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
