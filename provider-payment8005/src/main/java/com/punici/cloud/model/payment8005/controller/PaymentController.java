package com.punici.cloud.model.payment8005.controller;

import com.punici.cloud.model.dto.CommonResult;
import com.punici.cloud.model.payment8005.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import com.punici.cloud.model.payment8005.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping
@Slf4j
public class PaymentController
{
    @Autowired
    private PaymentService paymentService;
    
    @Value("${server.port}")
    private String serverPort;
    
    @PostMapping("/create")
    public CommonResult<Boolean> create(@RequestBody Payment payment)
    {
        log.info("{}", payment);
        paymentService.create(payment);
        return new CommonResult<>();
    }
    
    @GetMapping("/getPaymentById")
    public CommonResult<Payment> getPaymentById(@RequestParam("id") Long id)
    {
        return new CommonResult<>(paymentService.getPaymentById(id));
    }
    
    @GetMapping("/payment/zk")
    public String paymentZk()
    {
        return "springCloud with zookeeper:" + serverPort + "\t" + System.currentTimeMillis();
    }
}
