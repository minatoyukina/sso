package com.cjs.example.controller;

import com.cjs.example.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ccq
 * @since 2021/1/22 17:32
 */
@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping
    public User getUser() {
        User user = new User();
        user.setUsername("root");
        user.setPassword("123456");
        user.setAge(17);
        return user;
    }
}
