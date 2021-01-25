package com.cjs.example;

import com.alibaba.cloud.nacos.ribbon.NacosRule;
import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.netflix.loadbalancer.IRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;

@RefreshScope
@SpringBootApplication
@EnableDiscoveryClient
@EnableNacosConfig(globalProperties = @NacosProperties(serverAddr = "localhost:8848"))
public class CjsOauth2SsoGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CjsOauth2SsoGatewayApplication.class, args);
    }

    @Bean
    public IRule nacosRule() {
        return new NacosRule();
    }
}
