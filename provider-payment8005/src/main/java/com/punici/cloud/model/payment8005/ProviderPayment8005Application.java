package com.punici.cloud.model.payment8005;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPayment8005Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(ProviderPayment8005Application.class, args);
    }
}
