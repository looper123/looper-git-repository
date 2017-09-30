package com.quark.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ZhenpengLu on 2017/9/7.
 * configserver 启动文件 一定要放在所有包根路径下 （否则无法扫描到所有类）
 */
@Configuration
@EnableAutoConfiguration
//注册为服务
@EnableDiscoveryClient
//配置中心
@EnableConfigServer
public class ConfigServerApplication {

    public static void main(String[] args){
        SpringApplication.run(ConfigServerApplication.class,args);
    }
}
