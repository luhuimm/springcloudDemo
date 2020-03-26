package com.hui;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("feign-inherit-api")
public interface UserRemoteClient {

    @GetMapping("/getUser")
    String getUser();

}
