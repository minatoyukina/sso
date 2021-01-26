package com.cjs.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author ccq
 * @since 2021/1/25 16:49
 */
@Component
@Slf4j
public class RequestAuthFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("request URI: {}", exchange.getRequest().getURI().toString());
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
