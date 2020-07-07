package com.icey.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//开启eureka客户端支持
@EnableCircuitBreaker //注解开启断路器功能
public class ProjectNameDemoConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectNameDemoConsumerApplication.class, args);
	}

}
