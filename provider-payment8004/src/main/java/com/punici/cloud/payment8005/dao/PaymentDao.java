package com.punici.cloud.payment8005.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.punici.cloud.payment8005.entity.Payment;

@Mapper
public interface PaymentDao
{
    int create(Payment payment);
    
    Payment getPaymentById(@Param("id") Long id);
}
