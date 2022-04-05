package com.punici.cloud.oderfeign80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ConsumerFeignOrder80Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(ConsumerFeignOrder80Application.class);
    }
}
