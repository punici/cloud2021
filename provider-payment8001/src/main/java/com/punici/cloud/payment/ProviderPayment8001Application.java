package com.punici.cloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPayment8001Application
{
    
    public static void main(String[] args)
    {
        SpringApplication.run(ProviderPayment8001Application.class, args);
    }
    
}
