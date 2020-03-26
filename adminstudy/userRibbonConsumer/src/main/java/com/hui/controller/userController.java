package com.hui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class userController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getUser")
    public String getUser() {
        String url = "http://userProvider/getUser";
       return restTemplate.getForObject(url,String.class);
    }

}
