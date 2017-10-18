package com.quark.cloud.receiver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quark.cloud.HelloServiceApplication;
import com.quark.cloud.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.GenericMessage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ZhenpengLu on 2017/10/13.
 * 父模块收到的消息可以供子模块共享
 * 一个ying中 两个@StreamListener 修饰的方法不能定义同一个通道
 */
@EnableBinding(value = {MySink.class, MyInput.class,MyProcessor.class})
//如果input和output公用一个channel通道，如果定义了发布者 至少需要一个订阅者
public class MySinkReceiver {

    private static Logger logger = LoggerFactory.getLogger(HelloServiceApplication.class);

    //    接收定时发送消息 method 1 接收
// TODO: 2017/10/18  不能用Object类型接收参数 （会默认接收到一条 以通道名为内容的消息  如果再有其他消息发送过来 会报出找不到订阅者的错误）
//    @StreamListener(value = MySink.CHANNEL_NAME)
//    public void receive(UserEntity payload) {
//        logger.info("hello-service-MySinkReceiver" + payload);
//    }

    //   接收定时发送消息 method 2 接收
//    @ServiceActivator(inputChannel = MySink.CHANNEL_NAME)
//    public void receive2(String payload) {
//        logger.info("@ServiceActivator annotation" + payload);
//    }

    //通道声明  定时发送（2s一次）
//    @Bean
//    @InboundChannelAdapter(value = MySink.CHANNEL_NAME, poller = @Poller(fixedDelay = "2000"))
//    public MessageSource<Date> timeStampSource() {
//        return () -> new GenericMessage<>(new Date());
//    }

    //对通道中的消息进行格式转换 如果定义了两个消息接收者 只会对一个生效
//    @Transformer(inputChannel = MySink.CHANNEL_NAME, outputChannel = MySink.CHANNEL_NAME)
//    public Object DateTransForm(Date message) {
//        return new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss").format(message);
//    }

    //    定时发送json类型数据
//    @Bean
//    @InboundChannelAdapter(value = MyProcessor.INPUT_NAME, poller = @Poller(fixedDelay = "2000"))
//    public MessageSource<String> jsonDataSource() {
//        return () -> new GenericMessage<String>("{\"name\":\"looper\",\"age\":\"25\"}");
//    }

//    接收json类型数据并且转换成entity
//    @Transformer(inputChannel = MyInput.CHANNEL_NAME,outputChannel = MyOutput.CHANNEL_NAME)
//    public UserEntity jsonTransForm(String userJson){
//        ObjectMapper objectMapper = new ObjectMapper();
//        UserEntity  userEntity = null;
//        try {
//            userEntity = objectMapper.readValue(userJson, UserEntity.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//           return userEntity;
//    }

//    获取json转换后的消息数据
//    @ServiceActivator(inputChannel = MyInput.CHANNEL_NAME)
//    public void getFromJson(UserEntity userEntity){
//        logger.info("transform  by @ServiceActivator"+userEntity);
//    }


    //@StreamListener 注解根据配置实现自动转换 无需自己书写类型转换方法
//    @StreamListener(value = MyProcessor.INPUT_NAME)
////    把返回结果 发送给通道入口
//    @SendTo(value ="customer_channel")
//    public UserEntity getFromJson2(UserEntity userEntity) {
//        String s = null;
//        logger.info("transform by @StreamListener" + userEntity);
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            s = objectMapper.writeValueAsString(userEntity);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        return userEntity;
//    }
//
//
//    @StreamListener(value = Processor.INPUT)
////    把返回结果 发送给通道入口
//    @SendTo(value =Processor.OUTPUT)
//    public String channelInteractive(String message) {
//        String s = null;
//        logger.info("hello service--------get input" + message);
//        return "hello service------put output";
//    }


}
