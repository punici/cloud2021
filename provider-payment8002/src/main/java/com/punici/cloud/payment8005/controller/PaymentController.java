package com.punici.cloud.payment8005.controller;

import com.punici.cloud.payment8005.entity.Payment;
import com.punici.cloud.payment8005.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.punici.cloud.dto.CommonResult;

@RestController
@RequestMapping
@Slf4j
public class PaymentController
{
    @Autowired
    private PaymentService paymentService;
    
    @PostMapping("/create")
    public CommonResult<Boolean> create(@RequestBody Payment payment)
    {
        log.info("{}",payment);
        paymentService.create(payment);
        return new CommonResult<>();
    }
    
    @GetMapping("/getPaymentById")
    public CommonResult<Payment> getPaymentById(@RequestParam("id") Long id)
    {
        return new CommonResult<>(paymentService.getPaymentById(id));
    }
}
