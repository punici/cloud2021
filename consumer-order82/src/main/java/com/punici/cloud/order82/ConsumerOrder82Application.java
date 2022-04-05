package com.punici.cloud.order82;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConsumerOrder82Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(ConsumerOrder82Application.class);
    }
}
