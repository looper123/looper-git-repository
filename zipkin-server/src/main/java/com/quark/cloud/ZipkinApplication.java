package com.quark.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
import zipkin.server.EnableZipkinServer;

/**
 * Created by ZhenpengLu on 2017/10/20.
 */
@SpringBootApplication
//@EnableZipkinServer
//监听spring.cloud.stream.binder 绑定的消息中间件的获取到的sleuth消息 并且push 倒Zipkin SpanStore
@EnableZipkinStreamServer
public class ZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinApplication.class,args);
    }
}
