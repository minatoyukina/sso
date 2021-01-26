package com.cjs.example;

import com.cjs.example.config.FeignConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(defaultConfiguration = FeignConfig.class)
public class CjsOauth2ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CjsOauth2ConsumerApplication.class, args);
    }
}
