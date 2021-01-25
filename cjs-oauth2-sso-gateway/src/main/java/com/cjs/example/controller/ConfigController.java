package com.cjs.example.controller;

import com.cjs.example.config.GatewayConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ccq
 * @since 2021/1/25 10:42
 */
@RestController("config")
public class ConfigController {

    @Resource
    private GatewayConfig gatewayConfig;

    @GetMapping
    public Integer get() {
        return gatewayConfig.getLimit();
    }
}
