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
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import java.text.SimpleDateFormat;
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

//    通道声明 method 1 接收
    @StreamListener(MySink.CHANNEL_NAME)
    public void receive(String payload){
        logger.info("hello-service-MySinkReceiver"+payload);
    }



// 通道声明 method 2  接收 如果需要格式转换 只能在接收消息的方法中实现
    @ServiceActivator(inputChannel = MySink.CHANNEL_NAME)
    public void receive2(String payload){
        logger.info("@ServiceActivator annotation"+payload);
    }

//    通道声明  定时发送（2s一次）
    @Bean
    @InboundChannelAdapter(value = MySink.CHANNEL_NAME,poller = @Poller(fixedDelay ="2000"))
    public MessageSource<Date>  timeStampSource(){
        return () -> new GenericMessage<>(new Date());
    }

//    对通道中的消息进行格式转换 只对  @StreamListener 注解接收的消息生效
    @Transformer(inputChannel = MySink.CHANNEL_NAME,outputChannel = MySink.CHANNEL_NAME)
    public Object channelTransForm(Date message){
        return new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss").format(message);
    }

}
