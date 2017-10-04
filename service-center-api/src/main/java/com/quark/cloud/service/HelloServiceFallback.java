package com.quark.cloud.service;

import com.quark.cloud.entity.UserEntity;
import com.quark.cloud.service.api.HelloService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017/10/4/004.
 */
@Component
public class HelloServiceFallback implements HelloService {


    @Override
    public String hello() {
        return "hello error";
    }

    @Override
    public String hello1(@RequestParam("name") String name) {
        return "hello1 error";
    }

    @Override
    public UserEntity hello2(@RequestHeader("name") String name, @RequestHeader("age") String age) {
        return new UserEntity("no name","no age");
    }

    @Override
    public String hello3(@RequestBody UserEntity userEntity) {
        return "hello3 error";
    }
}
