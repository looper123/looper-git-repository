package com.quark.cloud.controller;

import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZhenpengLu on 2017/9/7.
 */
@RestController
@EnableCircuitBreaker
//@SpringCloudApplication   包含了服务发现、断路器等组件的注解
public class HelloController {

    @RequestMapping("hello")
    public String sayHello(){
        return "hello world!!";
    }
}
