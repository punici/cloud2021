package com.punici.cloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class HystrixPayment8001Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(HystrixPayment8001Application.class, args);
    }
}
