package com.punici.cloud.payment.service;

import com.punici.cloud.payment.entity.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService
{
    int create(Payment payment);
    
    Payment getPaymentById(@Param("id") Long id);
}