package com.productApi.service.impl;

import com.productApi.model.Role;
import com.productApi.model.User;
import com.productApi.repo.UserRepository;
import com.productApi.response.BaseResponse;
import com.productApi.service.RoleService;
import com.productApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    RoleService roleService;

    @Override
    public void save(User user) {
        Role role = roleService.findRoleByName("ROLE_USER");
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }

    @Override
    public ResponseEntity<?> findAll() {
        List<User> users = (List<User>) repository.findAll();
        for ( User u : users) {
            for (Role r : u.getRoles()) {
                r.setUsers(null);
            }
        }
        return getResponseEntity(users);
    }
}
