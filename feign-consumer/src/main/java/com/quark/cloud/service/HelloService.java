package com.quark.cloud.service;

import com.quark.cloud.entity.UserEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ZhenpengLu on 2017/9/29.
 */
@FeignClient("SAMPLE")
public interface HelloService {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String hello();

    @RequestMapping(value ="/hello1",method = RequestMethod.GET)
    String hello1(@RequestParam("name") String name);

    @RequestMapping(value ="/hello2",method = RequestMethod.GET)
    UserEntity hello2(@RequestHeader("name") String name, @RequestHeader("age") String age);

    @RequestMapping(value ="/hello3",method = RequestMethod.POST)
     String hello3(@RequestBody UserEntity userEntity);
}
