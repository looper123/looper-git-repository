package com.quark.cloud.receiver;

import com.quark.cloud.HelloServiceApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * Created by ZhenpengLu on 2017/10/13.
 */
//@EnableBinding(value = {Sink.class,Source.class})
// 注意sink 接口是spring cloud stream提供的默认实现 还有source和processor 可以查看源码学习如何用自定义接口绑定消息通道
@EnableBinding(value ={Sink.class,Source.class})
public class SinkReceiver {

   private static Logger logger = LoggerFactory.getLogger(HelloServiceApplication.class);

    @StreamListener(Sink.INPUT)
    public void receive(String payload){
            logger.info("SinkReceiver"+payload);
    }



}


