package com.quark.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ZhenpengLu on 2017/9/27.
 */
@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    private int successNum = 0;

    private int failNum = 0;

    public static final Logger logger = LoggerFactory.getLogger(HelloService.class);

    private Lock lock = new ReentrantLock();

    //定义超过信号量阈值时的回调函数
    @HystrixCommand(fallbackMethod = "helloFallBack",commandProperties = {
          @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE"),//还有一种THREAD策略
          @HystrixProperty(name = "execution.isolation.semaphore.maxConcurrentRequests",value = "50"),
          @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests",value = "1000")
    })
    public String helloConsumer(){
        long start = System.currentTimeMillis();
        String body = restTemplate.getForEntity("http://SAMPLE/hello", String.class).getBody();
        long end = System.currentTimeMillis();
        //为了打印的结果不受并发影响加上同步锁
        synchronized (lock){
            successNum++;
            System.out.println("成功的数量-------"+successNum);
        }
        return  body;
    }

    public String helloFallBack(){
        //为了打印的结果不受并发影响加上同步锁
        synchronized (this){
            failNum++;
            System.out.println("失败的数量——-------"+failNum);
        }
        return "error!";
    }




}
