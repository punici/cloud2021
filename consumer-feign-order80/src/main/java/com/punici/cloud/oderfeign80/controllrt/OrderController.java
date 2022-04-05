package com.punici.cloud.oderfeign80.controllrt;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.punici.cloud.model.dto.CommonResult;
import com.punici.cloud.model.entity.Payment;
import com.punici.cloud.oderfeign80.feign.PaymentFeignAPI;

@RestController
@RequestMapping("/order/consumer")
public class OrderController
{
    @Resource
    private PaymentFeignAPI paymentFeignAPI;
    
    @GetMapping("/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id)
    {
        return paymentFeignAPI.getPaymentById(id);
    }
}
