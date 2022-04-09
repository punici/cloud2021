package com.punici.cloud.payment.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.punici.cloud.model.entity.Payment;

public interface PaymentServiceAPI
{
    void create(Payment payment);
    
    Payment getPaymentById(@Param("id") Long id);
    
    String paymentInfoOK(@PathVariable("id") Integer id);
    
    String paymentTimeout(@PathVariable("id") Integer id);
    String paymentCircuitBreaker(@PathVariable("id") Integer id);
}