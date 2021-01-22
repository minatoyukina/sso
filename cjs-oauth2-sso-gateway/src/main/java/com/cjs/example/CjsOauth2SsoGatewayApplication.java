package com.cjs.example;

import com.alibaba.cloud.nacos.ribbon.NacosRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class CjsOauth2SsoGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CjsOauth2SsoGatewayApplication.class, args);
    }

    @Bean
    public IRule nacosRule() {
        return new NacosRule();
    }
}
