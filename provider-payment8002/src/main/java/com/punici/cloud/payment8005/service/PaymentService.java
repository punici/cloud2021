package com.punici.cloud.payment8005.service;

import org.apache.ibatis.annotations.Param;

import com.punici.cloud.model.entity.Payment;

public interface PaymentService
{
    void create(Payment payment);
    
    Payment getPaymentById(@Param("id") Long id);
}