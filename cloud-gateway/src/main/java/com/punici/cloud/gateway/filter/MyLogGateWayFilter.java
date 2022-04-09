package com.punici.cloud.gateway.filter;

import org.slf4j.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class MyLogGateWayFilter implements GlobalFilter, Ordered
{
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(MyLogGateWayFilter.class);
    
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain)
    {
        ServerHttpRequest request = exchange.getRequest();
        log.info("MyLogGateWayFilter,{}", request.getURI());
        String name = request.getQueryParams().getFirst("name");
        if(name == null)
        {
            log.info("MyLogGateWayFilter,name is null");
            exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }
    
    @Override
    public int getOrder()
    {
        return 0;
    }
}
