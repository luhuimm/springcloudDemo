package com.hui.controller;

import com.hui.UserRemoteClient;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController implements UserRemoteClient {
    @Override
    public String getUser() {
        return "haha";
    }
}
