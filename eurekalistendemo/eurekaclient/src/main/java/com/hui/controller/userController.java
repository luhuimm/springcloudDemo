package com.hui.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

    @GetMapping("/getUser")
    public String getUser() {
        return "hui";
    }
}
