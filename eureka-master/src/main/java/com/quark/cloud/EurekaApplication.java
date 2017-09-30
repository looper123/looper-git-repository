package com.quark.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by ZhenpengLu on 2017/9/7.
 */
//注册中心声明
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {

    public static void main(String[] args){
        SpringApplication.run(EurekaApplication.class,args);
    }
}
