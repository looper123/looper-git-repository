package com.quark.cloud.controller;

import com.quark.cloud.entity.UserEntity;
import org.springframework.web.bind.annotation.*;

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
        try {
            //测试feign ribbon/hystrix的超时、重试、熔断等参数是否生效
            int sleepTime = 100;
//            int sleepTime = 4000;
//            int sleepTime = new Random().nextInt(3000);
//            System.out.println("sleepTime========="+sleepTime);
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello world!!";
    }

//    @RequestMapping(value ="hello1",method = RequestMethod.GET)
//    public String sayHello(@RequestParam String name){
//        try {
//            //测试feign ribbon的超时等参数是否生效
//            Thread.sleep(2000);
////            Thread.sleep(new Random().nextInt(3000));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return "hello world "+name;
//    }
//
//    @RequestMapping(value ="hello2",method = RequestMethod.GET)
//    public UserEntity sayHello(@RequestHeader String name, @RequestHeader String age){
//        try {
//            //测试feign ribbon的超时等参数是否生效
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return new UserEntity(name,age);
//    }
//
//    @RequestMapping(value ="hello3",method = RequestMethod.POST)
//    public String sayHello(@RequestBody UserEntity userEntity){
//        try {
//            //测试feign ribbon的超时等参数是否生效
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return "hello world"+userEntity.getName()+userEntity.getAge();
//    }

}
