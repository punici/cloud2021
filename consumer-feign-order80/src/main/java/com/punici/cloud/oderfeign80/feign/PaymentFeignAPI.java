package com.punici.cloud.oderfeign80.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.punici.cloud.model.dto.CommonResult;
import com.punici.cloud.model.entity.Payment;

@FeignClient(value = "hystrix-payment-service")
@RequestMapping("/payment")
public interface PaymentFeignAPI
{
    @GetMapping("/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
    
    @GetMapping("/ok/{id}")
    String paymentInfoOK(@PathVariable("id") Integer id);
    
    @GetMapping("/timeout/{id}")
    String paymentTimeout(@PathVariable("id") Integer id);
    
}
