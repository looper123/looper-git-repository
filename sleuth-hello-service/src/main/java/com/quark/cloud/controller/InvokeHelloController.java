package com.quark.cloud.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ZhenpengLu on 2017/10/19.
 */
@RestController
public class InvokeHelloController {

    private final static Logger logger = LoggerFactory.getLogger(InvokeHelloController.class);

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value= "invokeHello")
    public String  InvokeHell(HttpServletRequest request){
        logger.info("===<call sleuth, TraceId={}, SpanId={}>===",
                request.getHeader("X-B3-TraceId"), request.getHeader("X-B3-SpanId"));
       return   restTemplate.getForEntity("http://SAMPLE/hello",String.class).getBody();
    }


}
