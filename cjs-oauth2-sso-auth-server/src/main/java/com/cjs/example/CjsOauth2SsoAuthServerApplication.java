package com.cjs.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CjsOauth2SsoAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CjsOauth2SsoAuthServerApplication.class, args);
    }
}
