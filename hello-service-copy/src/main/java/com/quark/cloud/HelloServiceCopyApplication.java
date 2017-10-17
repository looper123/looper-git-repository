package com.quark.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by ZhenpengLu on 2017/9/30.
 */
@SpringBootApplication
//@EnableEurekaClient
public class HelloServiceCopyApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloServiceCopyApplication.class,args);
    }
}
