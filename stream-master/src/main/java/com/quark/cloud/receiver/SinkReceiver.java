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

import java.util.Random;

/**
 * Created by ZhenpengLu on 2017/10/13.
 */
//@EnableBinding(value = {Sink.class,Source.class})
// 注意sink 接口是spring cloud stream提供的默认实现 还有source和processor 可以查看源码学习如何用自定义接口绑定消息通道
@EnableBinding(value = {Source.class})
public class SinkReceiver {

    private static Logger logger = LoggerFactory.getLogger(StreamApplication.class);

//    @StreamListener(Processor.INPUT)
//    public void receive(String payload){
//            logger.info("stream master----get iput"+payload);
//    }

//    @Bean
//    @InboundChannelAdapter(value = Source.OUTPUT,poller = @Poller(fixedDelay = "2000"))
//    public MessageSource<String> send(){
//        logger.info("stream master transform output to greetings is running");
//        return()-> new GenericMessage<>("stream master------put output");
//  }

    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "2000"))
    public MessageSource<PayLoadChild> send() {
        PayLoadChild child = new PayLoadChild();
        boolean flag = true;
//        模拟hash求出的值为0   即把消息发送到 index 为的0的机器上
        int i = 0;
        while (flag) {
            Random random = new Random();
            i = random.nextInt();
//            配置：  partitionKeyExpression: payload.partitionKey
//                   partitionCount: 2
//             公式：partitionKey.hashcode%partitionCount== 最后会得出一个在 0 - partitionCount的数值 就是最终
//             接收到消息的机器对应的partitionIndex
            if (("" + i).hashCode() % 2 == 0){
                flag = false;
            }
        }
        String key = "" + i;
        String value = "" + key.hashCode() % 2;
        child.setPartitionKey(key);
        child.setPartitionData(value);
        logger.info("---key----" + key + "---value---" + value);
        return () -> new GenericMessage<>(child);
    }


}


