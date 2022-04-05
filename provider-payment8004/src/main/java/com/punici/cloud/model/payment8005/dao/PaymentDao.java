package com.punici.cloud.model.payment8005.dao;

import com.punici.cloud.model.payment8005.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao
{
    int create(Payment payment);
    
    Payment getPaymentById(@Param("id") Long id);
}
