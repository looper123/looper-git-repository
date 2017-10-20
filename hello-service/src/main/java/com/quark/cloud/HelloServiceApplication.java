package com.quark.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ZhenpengLu on 2017/9/30.
 */
@SpringBootApplication
@EnableEurekaClient
public class HelloServiceApplication {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    //    alwaysSampler 初始化结果是true
//    也可以自定义 sampler的实现类 对需要被跟踪系统跟踪的日志做自定义处理
    @Bean
    AlwaysSampler defaultSampler(){
        return new AlwaysSampler();
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloServiceApplication.class,args);
    }
}
