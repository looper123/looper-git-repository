package com.quark.cloud.controller;

import com.quark.cloud.entity.UserEntity;
import org.springframework.web.bind.annotation.*;

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
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello world!!";
    }

    @RequestMapping(value ="hello1",method = RequestMethod.GET)
    public String sayHello(@RequestParam String name){
        return "hello world "+name;
    }

    @RequestMapping(value ="hello2",method = RequestMethod.GET)
    public UserEntity sayHello(@RequestHeader String name, @RequestHeader String age){
        return new UserEntity(name,age);
    }

    @RequestMapping(value ="hello3",method = RequestMethod.POST)
    public String sayHello(@RequestBody UserEntity userEntity){
        return "hello world"+userEntity.getName()+userEntity.getAge();
    }

}
