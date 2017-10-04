package com.quark.cloud.controller;

import com.quark.cloud.entity.UserEntity;
import com.quark.cloud.service.HelloServiceFallback;
import com.quark.cloud.service.api.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZhenpengLu on 2017/9/29.
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Autowired
    HelloServiceFallback helloServiceFallback;

    private  static Logger logger = LoggerFactory.getLogger(HelloService.class);

    /**
     * * feign ribbon test
     * @return
     */
    @RequestMapping(value = "/feign-consumer",method = RequestMethod.GET)
    public  String feignConsumer(){
        System.out.println("hello service hello method"+helloService.hello());
//        System.out.println("hello service hello1 method"+helloService.hello1("this is hello1"));
//        System.out.println("hello service hello2 method"+helloService.hello2("this is hello2","2"));
//        System.out.println("hello service hello3 method"+helloService.hello3(new UserEntity("this is hello3","3")));
       return  "success";
    }




}
