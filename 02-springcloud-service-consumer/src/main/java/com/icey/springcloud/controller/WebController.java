package com.icey.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WebController {
    @Autowired
    private RestTemplate restTemplate2;
    @RequestMapping("/web/hello")
    public String hello(){
        //逻辑判断（省略）
        //调用SpringCloud服务提供者提供的服务
      //  return restTemplate2.getForEntity("http://localhost:8080/service/hello",String.class).getBody();
         return restTemplate2.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/hello",String.class).getBody();
    }
}
