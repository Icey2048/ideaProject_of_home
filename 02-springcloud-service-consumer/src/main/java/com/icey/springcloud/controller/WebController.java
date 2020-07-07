package com.icey.springcloud.controller;

import com.icey.springcloud.model.User;
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
public class WebController {
    @Autowired
    private RestTemplate restTemplate2;
    @RequestMapping("/web/hello")
    public String hello(){
        //逻辑判断（省略）
        //调用SpringCloud服务提供者提供的服务
      //  return restTemplate2.getForEntity("http://localhost:8080/service/hello",String.class).getBody();

        ResponseEntity<String> responseEntity = restTemplate2.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/hello",
                        String.class);
        String body = responseEntity.getBody();
        HttpStatus statusCode = responseEntity.getStatusCode();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpHeaders headers = responseEntity.getHeaders();
        System.out.println(body);
        System.out.println(statusCode);
        System.out.println(statusCodeValue);
        System.out.println(headers);
        return restTemplate2.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/hello",String.class).getBody();
    }

    @RequestMapping("/web/user")
    public User user(){
        ResponseEntity<User> responseEntity = restTemplate2.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/user",
                User.class);
        User body = responseEntity.getBody();
        HttpStatus statusCode = responseEntity.getStatusCode();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpHeaders headers = responseEntity.getHeaders();
        System.out.println(body);
        System.out.println(statusCode);
        System.out.println(statusCodeValue);
        System.out.println(headers);
        return restTemplate2.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/user",User.class).getBody();
    }
    @RequestMapping("/web/getUser")
    public User getUser(){
        String[] strArrary={"105","黄亚萍","18713579356"};
        ResponseEntity<User> responseEntity = restTemplate2.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/getUser?id={0}&name={1}&phone={2}",
                User.class,strArrary);
        User body = responseEntity.getBody();
        HttpStatus statusCode = responseEntity.getStatusCode();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpHeaders headers = responseEntity.getHeaders();
        System.out.println(body);
        System.out.println(statusCode);
        System.out.println(statusCodeValue);
        System.out.println(headers);
        return restTemplate2.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/getUser?id={0}&name={1}&phone={2}",User.class,strArrary).getBody();
    }

    @RequestMapping("/web/getUser2")
    public User getUser2(){
        //String[] strArrary={"105","黄亚萍","18713579356"};
        Map<String,Object> paramMap=new ConcurrentHashMap<>();
        paramMap.put("id",1048);
        paramMap.put("name","亚萍Map");
        paramMap.put("phone","182344546");
        ResponseEntity<User> responseEntity = restTemplate2.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/getUser?id={id}&name={name}&phone={phone}",
                User.class,paramMap);
        User body = responseEntity.getBody();
        HttpStatus statusCode = responseEntity.getStatusCode();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpHeaders headers = responseEntity.getHeaders();
        System.out.println(body);
        System.out.println(statusCode);
        System.out.println(statusCodeValue);
        System.out.println(headers);
        return restTemplate2.getForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/getUser?id={id}&name={name}&phone={phone}",User.class,paramMap).getBody();
    }

    @RequestMapping("/web/getUser3")
    public User getUser3(){
        //String[] strArrary={"105","黄亚萍","18713579356"};
        Map<String,Object> paramMap=new ConcurrentHashMap<>();
        paramMap.put("id",1048);
        paramMap.put("name","亚萍Map");
        paramMap.put("phone","182344546");
        User user = restTemplate2.getForObject("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/getUser?id={id}&name={name}&phone={phone}",
                User.class,paramMap);

        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getPhone());
        return restTemplate2.getForObject("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/getUser?id={id}&name={name}&phone={phone}",User.class,paramMap);
    }

    @RequestMapping("/web/addUser")
    public User addUser(){
        MultiValueMap paramMap=new LinkedMultiValueMap();
        paramMap.add("id","1048");
        paramMap.add("name","亚萍post");
        paramMap.add("phone","182344546");
        ResponseEntity<User> responseEntity = restTemplate2.postForEntity(
                "http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/getUser",
                paramMap,
                User.class);
        return restTemplate2.postForEntity("http://01-SPRINGCLOUD-SERVICE-PROVIDER/service/getUser",paramMap,User.class).getBody();
    }

}
