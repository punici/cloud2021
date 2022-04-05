package com.punici.cloud.payment.controller;

import java.util.List;

import javax.annotation.Resource;

import com.punici.cloud.model.dto.CommonResult;
import com.punici.cloud.model.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import com.punici.cloud.payment.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController
{
    @Autowired
    private PaymentService paymentService;
    
    @Resource
    private DiscoveryClient discoveryClient;
    
    @Value("${server.port}")
    private String serverPort;
    
    @PostMapping("/create")
    public CommonResult<Boolean> create(@RequestBody Payment payment)
    {
        paymentService.create(payment);
        return new CommonResult<>();
    }
    
    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id)
    {
        CommonResult<Payment> result = new CommonResult<>(paymentService.getPaymentById(id));
        result.setCode(Integer.parseInt(serverPort));
        return result;
    }
    
    @GetMapping("/payment/discovery")
    public Object discovery()
    {
        List<String> services = discoveryClient.getServices();
        for(String element : services)
        {
            log.info("*****element:{}", element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-SERVICE");
        for(ServiceInstance instance : instances)
        {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return discoveryClient;
    }
}
