package com.cjs.example.controller;

import com.cjs.example.entity.User;
import com.cjs.example.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ccq
 * @since 2021/1/22 17:15
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping
    public User getUser() {
        return userService.getUser();
    }
}
