package com.juperdog.authserv.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by wasan_kha on 10/6/2017 AD.
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

//    @Autowired
//    AuthenticationManager authenticationManager;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.parentAuthenticationManager(authenticationManager)
//            .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll();


    }

}
