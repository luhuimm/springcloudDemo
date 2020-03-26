package com.hui.service;

import com.hui.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "userProvider",configuration = FeignConfiguration.class)
public interface UserService {

    @GetMapping("/getUser")
    String getUser();
}
