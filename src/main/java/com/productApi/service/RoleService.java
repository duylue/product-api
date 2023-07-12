package com.productApi.service;

import com.productApi.model.Role;

import java.util.List;

public interface RoleService {
    void saveRole(Role role);
    Role findRoleByName(String name);
    List<Role> findAll();

}
