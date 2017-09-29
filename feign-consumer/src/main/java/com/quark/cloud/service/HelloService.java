package com.quark.cloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ZhenpengLu on 2017/9/29.
 */
@FeignClient("SAMPLE")
public interface HelloService {

    @RequestMapping("/hello")
    String hello();
}
