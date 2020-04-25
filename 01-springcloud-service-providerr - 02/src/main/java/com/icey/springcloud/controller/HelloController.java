package com.icey.springcloud.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/service/hello")
    public String hello(){
        //进行业务处理（咱省略）
        System.out.println("服务提供者2.。。");
        return "Hello, it’s the message from provider2.";
    }
}
