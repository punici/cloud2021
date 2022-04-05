package com.punici.cloud.oder80.controllrt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order/consumer")
public class OrderController
{
    public static final String URL="http://CLOUD-ORDER-SERVICE";
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getOrder")
    public String getOrder()
    {
        return restTemplate.getForObject(URL+"/order/getOrder",String.class);
    }

    @RequestMapping("/create/payment")
    public String createPayment(){
        return "get";
    }
}
