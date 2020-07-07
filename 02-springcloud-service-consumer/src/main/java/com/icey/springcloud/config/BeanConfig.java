package com.icey.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration //等价于一个spring applicationContext.xml配置文件
public class BeanConfig {
    /**
     * @Bean 等价于：<bean id="restTemplate" class="RestTemplate"></bean>
     * //此处的class就省略包名了 ，xxx.xxx.xxx.RestTemplate
     *
     * @return
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 覆盖原来的ribbon默认的轮询的负载均衡策略
     * @return
     */
    @Bean
    public IRule iRule(){
        return new RandomRule();
    }

}
