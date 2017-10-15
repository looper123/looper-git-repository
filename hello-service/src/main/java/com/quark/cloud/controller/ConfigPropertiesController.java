package com.quark.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZhenpengLu on 2017/10/9.
 */
@RestController
@RefreshScope
public class ConfigPropertiesController {

//    服务启动时会就会立即加载倒容器（如果加载不到会报错）
//    @Value("${from}")
//    private String from;

    @Autowired
    private Environment environment;

//    @RequestMapping("/from")
//    public String getFrom(){
//        String from = this.from;
//        return from ;
//    }

    @RequestMapping("/from2")
    public  String getFrom2(){
        String from = environment.getProperty("from");
        return from ;
    }
}
