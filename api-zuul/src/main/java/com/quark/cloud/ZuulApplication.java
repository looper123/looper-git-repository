package com.quark.cloud;

import com.quark.cloud.filters.MyGatewayFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

/**
 * Created by Administrator on 2017/10/5/005.
 * zuul网关
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class,args);
    }

    /**
     * 自定义过滤器注册
     * @return
     */
    @Bean
    public MyGatewayFilter myFilter(){
        return  new MyGatewayFilter();
    }

    /**
     * 自定义路由规则
     * @return
     */
    @Bean
    public PatternServiceRouteMapper patternServiceRouteMapper(){
            return new PatternServiceRouteMapper(
              "(?<name>^.+)-(?<version>v.+$)",
             "${version}/${name}");

    }
}
