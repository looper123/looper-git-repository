package com.quark.cloud.receiver;

import ch.qos.logback.core.util.FixedDelay;
import com.quark.cloud.HelloServiceApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import java.util.Date;

/**
 * Created by ZhenpengLu on 2017/10/13.
 * 父模块收到的消息可以供子模块共享
 */
@EnableBinding(value ={MySink.class})
//注意这里不能写成@EnableBinding(value ={MySink.class,MySource.class})
//如果input和output公用一个channel通道，它们一定是一（output）对多（input）的关系
//即发送一条消息到exchenge中后，可以被多个服务所接收
public class MySinkReceiver {

    private static Logger logger = LoggerFactory.getLogger(HelloServiceApplication.class);

//    通道声明 method 1
    @StreamListener(MySink.CHANNEL_NAME)
    public void receive(String payload){
        logger.info("hello-service-MySinkReceiver"+payload);
    }



// 通道声明 method 2
//    @ServiceActivator(inputChannel = MySink.CHANNEL_NAME)
//    public void receive2(String payload){
//        logger.info("@ServiceActivator annotation"+payload);
//    }

//    通道声明 method 3
//    @Bean
//    @InboundChannelAdapter(value = MySource.CHANNEL_NAME,poller = @Poller(fixedDelay ="2000"))
//    public MessageSource<Date>  timeStampSource(){
//        return () -> new GenericMessage<>(new Date());
//    }


}
