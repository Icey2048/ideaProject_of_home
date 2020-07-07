package com.icey.springcloud.controller;

import com.icey.springcloud.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class HystrixController {
    @Autowired
    private RestTemplate restTemplate2;
    @RequestMapping("/web/hystrix")
    @HystrixCommand(fallbackMethod="error")
    public String hystrix(){
        return restTemplate2.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/hello",String.class)
                .getBody();
    }
 public String error(){
        return "error desgined by hystrix";
 }
}
