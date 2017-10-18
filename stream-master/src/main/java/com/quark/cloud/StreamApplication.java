package com.quark.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by ZhenpengLu on 2017/10/13.
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamApplication.class,args);
    }
}
