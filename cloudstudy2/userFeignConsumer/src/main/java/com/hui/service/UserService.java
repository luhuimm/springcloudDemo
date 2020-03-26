package com.hui.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient("UserProvider")
public interface UserService {

    @GetMapping("/getUser")
    String getUser() ;
}
