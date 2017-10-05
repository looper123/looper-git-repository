package com.quark.cloud.configuration;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by Administrator on 2017/10/3/003.
 * close hystrix by customer configuration
 */
//@Configuration
//public class HystrixDisabledConfig {
//
//    @Bean
//    @Scope("prototype")
//    public Feign.Builder  FeignBuilder(){
//        return Feign.builder();
//    }
//}
