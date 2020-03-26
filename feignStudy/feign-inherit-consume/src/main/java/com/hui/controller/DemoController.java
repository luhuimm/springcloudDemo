package com.hui.controller;

import com.hui.UserRemoteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private UserRemoteClient userRemoteClient;

    @GetMapping("/callUser")
    public String callGetUser(){
        return userRemoteClient.getUser();
    }

}
