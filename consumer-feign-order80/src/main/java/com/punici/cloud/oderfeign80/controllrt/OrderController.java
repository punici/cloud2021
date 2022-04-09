package com.punici.cloud.oderfeign80.controllrt;

import javax.annotation.Resource;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.punici.cloud.model.dto.CommonResult;
import com.punici.cloud.model.entity.Payment;
import com.punici.cloud.oderfeign80.feign.PaymentFeignAPI;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/order")
@Slf4j
@DefaultProperties(defaultFallback="paymentGlobalFallbackMethod")
public class OrderController
{
    @Resource
    private PaymentFeignAPI paymentFeignAPI;
    
    @GetMapping("/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id)
    {
        return paymentFeignAPI.getPaymentById(id);
    }
    
    @GetMapping("/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id)
    {
        return paymentFeignAPI.paymentInfoOK(id);
    }
//    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler",
//            commandProperties = { @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500") })

    @GetMapping("/timeout/{id}")
    @HystrixCommand
   public String paymentTimeout(@PathVariable("id") Integer id)
    {
        return paymentFeignAPI.paymentTimeout(id);
    }
    
    private String paymentInfoTimeOutHandler(Integer id)
    {
        log.info("paymentInfoTimeOutHandler,id:{}", id);
        return "我是80消费者，支付系统繁忙请稍后重试";
    }

    public String paymentGlobalFallbackMethod() {
        return "Gloable异常处理信息，请稍后再试";
    }
}
