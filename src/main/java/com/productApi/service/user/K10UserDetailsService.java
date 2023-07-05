package com.productApi.service.user;

import com.productApi.model.user.User;
import com.productApi.model.user.UserDetail;
import com.productApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class K10UserDetailsService implements UserDetailsService {
    private final UserService service;
    public K10UserDetailsService(UserService service) {
        this.service = service;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = service.findByUsername(username);
        return new UserDetail(user);
    }
}
