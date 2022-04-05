package com.punici.cloud.oderfeign80.feign;

import com.punici.cloud.model.entity.Payment;
import com.punici.cloud.model.dto.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "payment-service")
@RequestMapping("/payment")
public interface PaymentFeignAPI
{
    @GetMapping("/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
