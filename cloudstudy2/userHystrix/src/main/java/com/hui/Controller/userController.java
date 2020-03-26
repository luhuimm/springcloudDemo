package com.hui.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class userController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getUser")
    @HystrixCommand(fallbackMethod = "defaultCallGetUser")
    public String getUser() {
        String url = "http://USERPROVIDER/getUser";

        return restTemplate.getForObject(url, String.class);
    }

    public  String defaultCallGetUser() {

        return "fail";
    }

}
