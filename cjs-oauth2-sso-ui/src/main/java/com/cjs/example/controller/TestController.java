package com.cjs.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ccq
 * @since 2021/1/21 10:39
 */
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping
    public String test() {
        return "test";
    }

    @PostMapping
    public String write() {
        return "write";
    }
}
