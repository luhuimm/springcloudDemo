package com.hui.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient(value = "userProvider",fallback = UserRemoteClientFallBack.class)
public interface UserService {

    @GetMapping("/getUser")
     String getUser();
}
