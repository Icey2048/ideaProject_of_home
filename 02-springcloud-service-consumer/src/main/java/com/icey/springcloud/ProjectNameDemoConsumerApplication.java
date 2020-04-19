package com.icey.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//开启eureka客户端支持
public class ProjectNameDemoConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectNameDemoConsumerApplication.class, args);
	}

}
