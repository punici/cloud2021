package com.punici.cloud.payment8005.service.impl;

import com.punici.cloud.payment8005.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.punici.cloud.model.entity.Payment;
import com.punici.cloud.payment8005.dao.PaymentDao;

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
