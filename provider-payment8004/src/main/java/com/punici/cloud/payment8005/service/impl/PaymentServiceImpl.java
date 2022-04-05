package com.punici.cloud.payment8005.service.impl;

import com.punici.cloud.payment8005.dao.PaymentDao;
import com.punici.cloud.payment8005.entity.Payment;
import com.punici.cloud.payment8005.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
