package com.punici.cloud.oderfeign80.controllrt;

import com.punici.cloud.model.dto.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.punici.cloud.model.oderfeign80.entity.Payment;

@RestController
@RequestMapping("/order/consumer")
public class OrderController
{
    public static final String URL = "http://PAYMENT-SERVICE";
    
    @Autowired
    private RestTemplate restTemplate;
    
    @RequestMapping("/getOrder")
    public String getOrder()
    {
        return restTemplate.getForObject(URL + "/order/getOrder", String.class);
    }
    
    @RequestMapping("/create/payment")
    public String createPayment()
    {
        return "get";
    }
    
    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") String id)
    {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(URL + "/payment/get/" + id, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful())
        {
            return entity.getBody();
        }
        else
        {
            return new CommonResult<>(444, "操作失败");
        }
    }
}
