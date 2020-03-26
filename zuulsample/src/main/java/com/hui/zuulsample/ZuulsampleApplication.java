package com.hui.zuulsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulsampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulsampleApplication.class, args);
    }

}
