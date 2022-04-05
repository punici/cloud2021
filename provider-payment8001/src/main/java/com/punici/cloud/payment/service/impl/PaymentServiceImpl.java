package com.punici.cloud.payment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.punici.cloud.model.entity.Payment;
import com.punici.cloud.payment.dao.PaymentDao;
import com.punici.cloud.payment.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService
{
    @Autowired
    private PaymentDao paymentDao;
    
    @Override
    public void create(Payment payment)
    {
        paymentDao.create(payment);
    }
    
    @Override
    public Payment getPaymentById(Long id)
    {
        return paymentDao.getPaymentById(id);
    }
}
