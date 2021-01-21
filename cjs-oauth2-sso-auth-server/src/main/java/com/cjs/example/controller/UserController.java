package com.cjs.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @GetMapping("/user/me")
    public Principal user(Principal principal) {
        System.out.println("==================" + principal);
        return principal;
    }

    @PostMapping("user")
    public String write() {
        return "write";
    }

}
