package com.hui.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class userController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getUser")
    @HystrixCommand(fallbackMethod = "defaultGetUser")
    public String getUser() {
        String url = "http://userProvider/getUser";
       return restTemplate.getForObject(url,String.class);
    }

    public String defaultGetUser() {
        return "fail";
    }

}
