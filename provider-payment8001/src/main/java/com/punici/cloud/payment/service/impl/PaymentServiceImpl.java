package com.punici.cloud.payment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.punici.cloud.payment.dao.PaymentDao;
import com.punici.cloud.payment.entity.Payment;
import com.punici.cloud.payment.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService
{
    @Autowired
    private PaymentDao paymentDao;
    
    @Override
    public int create(Payment payment)
    {
        return paymentDao.create(payment);
    }
    
    @Override
    public Payment getPaymentById(Long id)
    {
        return paymentDao.getPaymentById(id);
    }
}
