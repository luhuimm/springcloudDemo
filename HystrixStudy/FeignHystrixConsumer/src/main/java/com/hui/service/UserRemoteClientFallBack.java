package com.hui.service;

import org.springframework.stereotype.Component;

@Component
public class UserRemoteClientFallBack implements UserService {
    @Override
    public String getUser() {
        return "fail";
    }
}
