package com.punici.cloud.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.punici.cloud.dto.CommonResult;
import com.punici.cloud.payment.entity.Payment;
import com.punici.cloud.payment.service.PaymentService;

@RestController
@RequestMapping
public class PaymentController
{
    @Autowired
    private PaymentService paymentService;
    
    @PostMapping("/create")
    public CommonResult<Boolean> create(@RequestBody Payment payment)
    {
        paymentService.create(payment);
        return new CommonResult<>();
    }
    
    @GetMapping("/getPaymentById")
    public CommonResult<Payment> getPaymentById(@RequestParam("id") Long id)
    {
        return new CommonResult<>(paymentService.getPaymentById(id));
    }
}
