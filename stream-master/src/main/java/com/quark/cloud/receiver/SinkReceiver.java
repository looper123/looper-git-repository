package com.quark.cloud.receiver;

import com.quark.cloud.StreamApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * Created by ZhenpengLu on 2017/10/13.
 */
//@EnableBinding(value = {Sink.class,Source.class})
@EnableBinding(value =Sink.class)
public class SinkReceiver {

   private static Logger logger = LoggerFactory.getLogger(StreamApplication.class);

    @StreamListener(Sink.INPUT)
    public void receive(String payload){
            logger.info("message received"+payload);
    }
}


