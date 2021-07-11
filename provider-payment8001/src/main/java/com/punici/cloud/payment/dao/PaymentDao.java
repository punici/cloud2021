package com.punici.cloud.payment.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.punici.cloud.payment.entity.Payment;

@Mapper
public interface PaymentDao
{
    int create(Payment payment);
    
    Payment getPaymentById(@Param("id") Long id);
}
