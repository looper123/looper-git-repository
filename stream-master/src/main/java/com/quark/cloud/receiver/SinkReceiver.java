package com.quark.cloud.receiver;

import com.quark.cloud.StreamApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

/**
 * Created by ZhenpengLu on 2017/10/13.
 */
//@EnableBinding(value = {Sink.class,Source.class})
// 注意sink 接口是spring cloud stream提供的默认实现 还有source和processor 可以查看源码学习如何用自定义接口绑定消息通道
// 不能重复定义通道
@EnableBinding(value ={Source.class})
public class SinkReceiver {

   private static Logger logger = LoggerFactory.getLogger(StreamApplication.class);

//    @StreamListener(Processor.INPUT)
//    public void receive(String payload){
//            logger.info("stream master----get iput"+payload);
//    }

    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT,poller = @Poller(fixedDelay = "2000"))
    public MessageSource<String> send(){
        logger.info("stream master transform output to greetings is running");
        return()-> new GenericMessage<>("stream master------put output");
  }



}


