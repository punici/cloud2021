package com.punici.cloud.payment.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.punici.cloud.model.entity.Payment;
import com.punici.cloud.payment.dao.PaymentDao;
import com.punici.cloud.payment.service.PaymentServiceAPI;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentServiceAPIImpl implements PaymentServiceAPI
{
    @Autowired
    private PaymentDao paymentDao;
    
    @Value("${server.port}")
    private String serverPort;
    
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
    
    @Override
    public String paymentInfoOK(Integer id)
    {
        log.info("*****paymentInfoOK,id:{}", id);
        return String.format("线程池：%s\t paymentInfoOK,id:%d\t%s", Thread.currentThread().getName(), id, serverPort);
        
    }
    
    @Override
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackHandler",
            commandProperties = { @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000") })
    public String paymentTimeout(Integer id)
    {
        log.info("*****paymentInfoTimeout,id:{}", id);
        try
        {
            TimeUnit.SECONDS.sleep(5);
        }
        catch (Exception e)
        {
            log.error("*****error:", e);
        }
        return String.format("线程池：%s\t paymentInfo timeOut,id:%d\t%s", Thread.currentThread().getName(), id, serverPort);
        
    }
    
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallbackHandler",
            commandProperties = { @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") })
    public String paymentCircuitBreaker(Integer id)
    {
        if(id < 0)
        {
            throw new RuntimeException("*****id 不能为负数");
        }
        String serialNumber = String.valueOf(id);
        return Thread.currentThread().getName() + "\t调用成功，流水号" + serialNumber + "\t" + this.serverPort;
    }
    
    public String paymentCircuitBreakerFallbackHandler(Integer id)
    {
        return "id 不能为负数，请稍后再试，/******id:" + id;
    }
    
    private String paymentTimeOutFallbackHandler(Integer id)
    {
        log.info("*****paymentInfoFallback,id:{}", id);
        return String.format("线程池：%s\t paymentInfo TimeOutFallbackHandler,id:%d\t%s", Thread.currentThread().getName(), id,
                serverPort);
    }
}
