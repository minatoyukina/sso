package com.cjs.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CjsOauth2ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CjsOauth2ConsumerApplication.class, args);
    }
}
