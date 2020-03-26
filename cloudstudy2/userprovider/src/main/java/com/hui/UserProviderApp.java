package com.hui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UserProviderApp {


    public static void main(String[] args) {

        SpringApplication.run(UserProviderApp.class, args);

    }
}
