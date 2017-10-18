package com.quark.cloud.receiver;

import com.quark.cloud.HelloServiceCopyApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * Created by ZhenpengLu on 2017/10/13.
 */
//@EnableBinding(value = {Sink.class,Source.class})
// 注意sink 接口是spring cloud stream提供的默认实现 还有source和processor 可以查看源码学习如何用自定义接口绑定消息通道
@EnableBinding(value ={Sink.class,MyInput.class})
public class SinkReceiver {

   private static Logger logger = LoggerFactory.getLogger(HelloServiceCopyApplication.class);

//    @StreamListener(Sink.INPUT)
//    public void receive(String payload){
//            logger.info("hello service copy get----greetings"+payload);
//    }

//    test for partitionKeyExpression in   properties
    @StreamListener(Sink.INPUT)
    public void receiveChild(PayLoadChild child){
        logger.info("hello service copy get----greetings"+"----key---"+child.getPartitionKey()+"----data---"+child.getPartitionData());
    }
//    @Bean
//    @InboundChannelAdapter(value = Processor.OUTPUT,poller = @Poller(fixedDelay = "2000"))
//    public MessageSource<String> send(){
//        return()-> new GenericMessage<String>("SinkReceiver-----output");
//  }



}


