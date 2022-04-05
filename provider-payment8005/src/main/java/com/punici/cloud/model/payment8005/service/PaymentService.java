package com.punici.cloud.model.payment8005.service;

import com.punici.cloud.model.payment8005.entity.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService
{
    void create(Payment payment);
    
    Payment getPaymentById(@Param("id") Long id);
}