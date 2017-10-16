package com.juperdog.authserv.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by wasan_kha on 10/6/2017 AD.
 */
@RestController
public class UserController {

    @GetMapping("/user/me")
    public Principal getUser(Principal principal){
        return principal;
    }
}
