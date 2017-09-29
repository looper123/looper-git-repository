package com.quark.cloud.controller;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by ZhenpengLu on 2017/9/7.
 */
@RestController
public class HelloController {

    @RequestMapping("hello")
    public String sayHello(){
        //为了测试熔断机制 让线程睡(0-3秒 以便随机触发熔断)
//        try {
//            Thread.sleep(new Random().nextInt(3000));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "hello world!!";
    }
}
