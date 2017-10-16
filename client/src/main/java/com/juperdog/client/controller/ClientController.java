package com.juperdog.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wasan_kha on 10/9/2017 AD.
 */
@RestController
public class ClientController {

    @Autowired
    private OAuth2RestTemplate oAuth2RestTemplate;


    @GetMapping("/foos")
    public String getFoos(){
        ResponseEntity<String> responseEntity = oAuth2RestTemplate.getForEntity("http://localhost:8080/foos", String.class);
        return responseEntity.getBody();
    }
}
