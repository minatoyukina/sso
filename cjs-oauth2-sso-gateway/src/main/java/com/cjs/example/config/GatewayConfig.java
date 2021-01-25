package com.cjs.example.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import lombok.Data;
import org.springframework.context.annotation.Configuration;

/**
 * @author ccq
 * @since 2021/1/25 10:34
 */
@Configuration
@Data
@NacosPropertySource(dataId = "gateway-config.properties", autoRefreshed = true)
public class GatewayConfig {

    @NacosValue(value = "${limit:1}", autoRefreshed = true)
    private Integer limit;
}
