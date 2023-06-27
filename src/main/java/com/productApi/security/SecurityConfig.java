//package com.productApi.security;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.SecurityBuilder;
//import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//      http.csrf().disable().
//    }
//
//    @Override
//    protected AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManager();
//    }
//}
