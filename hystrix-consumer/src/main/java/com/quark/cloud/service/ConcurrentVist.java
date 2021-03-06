package com.quark.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;

/**
 * Created by ZhenpengLu on 2017/9/28.
 * 断路器信号量模式测试
 */
@RestController
public class ConcurrentVist {

    @Autowired
    private HelloService helloService;


//  重复测试需要重启（CountDownLatch 初始化一次）
    @RequestMapping(value = "CirCuitBreaker", method = RequestMethod.GET)
    public void CirCuitBreaker() throws InterruptedException {
        //CountDownLatch  当signal. countDown()的调用次数超过初始化的值后 所有 signal.await()的线程都会启动
        final CountDownLatch signal = new CountDownLatch(100);

        for(int i=0; i< 100;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        signal.countDown();
                        signal.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String s = helloService.helloConsumer();
                    System.out.println(s + "--------------" + new Thread().getName());
                }
            }).start();
        }
        System.out.println("main Thread--------------" + new Thread().getName());
    }


}
