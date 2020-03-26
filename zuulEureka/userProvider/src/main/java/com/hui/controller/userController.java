package com.hui.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/getUser")
    public String getUser() {
//        Thread.sleep(9000);
        return "hui:" + port;
    }
}
