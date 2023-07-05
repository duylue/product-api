//package com.productApi.security;
//
//import com.productApi.service.user.K10UserDetailsService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    public SecurityConfig(K10UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//
//    private final K10UserDetailsService userDetailsService;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeHttpRequests().antMatchers("/auth/**").permitAll()
//                .anyRequest().hasAnyAuthority().and().formLogin().and()
//                .logout();
//
//
//    }
//
//    @Bean
//    @Override
//    protected AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManager();
//    }
//
//}
