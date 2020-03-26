package com.hui.Controller;

import com.hui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public String getUser() {
        return userService.getUser();
    }

}
