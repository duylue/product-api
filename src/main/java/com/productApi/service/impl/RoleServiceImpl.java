package com.productApi.service.impl;

import com.productApi.model.Role;
import com.productApi.repo.RoleRepository;
import com.productApi.service.RoleService;
import org.springframework.stereotype.Service;
 
import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveRole(Role role) {


        roleRepository.save(role);
    }


    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public List<Role> findAll() {
        return (List<Role>) roleRepository.findAll();
    }
}
