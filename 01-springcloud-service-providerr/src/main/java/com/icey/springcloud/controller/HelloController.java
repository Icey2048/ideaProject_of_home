package com.icey.springcloud.controller;


import com.icey.springcloud.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/service/hello")
    public String hello(){
        //进行业务处理（咱省略）
        System.out.println("服务提供者1");
        return "Hello, it’s the message from provider1.";
    }
    @RequestMapping("/service/user")
    public User user(){
        //进行业务处理（咱省略）
        System.out.println("服务提供者1");
        User user =new User();
        user.setName("hyp");
        user.setId(110);
        user.setPhone("18713579356");
        return user;
    }
    @RequestMapping("/service/getUser")
    public User getUser(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("phone") String phone){
        //进行业务处理（咱省略）
        System.out.println("服务提供者1");
        User user =new User();
        user.setName(name);
        user.setId(id);
        user.setPhone(phone);
        return user;
    }
    @RequestMapping(value = "/service/addUser",method = RequestMethod.POST)
    //@PostMapping=("/service/addUser")
    public User addUser(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("phone") String phone){
        //进行业务处理（咱省略）
        System.out.println("服务提供者1");
        User user =new User();
        user.setName(name);
        user.setId(id);
        user.setPhone(phone);
        return user;
    }
}
