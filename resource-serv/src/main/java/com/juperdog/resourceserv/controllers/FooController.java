package com.juperdog.resourceserv.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wasan_kha on 10/6/2017 AD.
 */
@RestController
public class FooController {

    @PreAuthorize("#oauth2.hasScope('read')")
    @RequestMapping(method = RequestMethod.GET, value = "/foos")
    public String getFoos(){
        return "find - all - foos";
    }


    @PreAuthorize("#oauth2.hasScope('write')")
    @RequestMapping(method = RequestMethod.POST, value = "/foos")
    public String postFoos(){
        return "find - all - foos";
    }
}
