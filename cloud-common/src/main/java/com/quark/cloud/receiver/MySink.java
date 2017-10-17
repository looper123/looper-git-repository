package com.quark.cloud.receiver;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by ZhenpengLu on 2017/10/13.
 * 自定义消息通道接口 - 入口
 */
public interface MySink {

    String CHANNEL_NAME = "customer_channel";

    @Input(MySink.CHANNEL_NAME)
//    返回值固定 SubscribableChannel定义了维护消息通道订阅者的方法
    SubscribableChannel myInput();

//  可以定义多个通道
//    @Input("customer_channel_01")
//    SubscribableChannel myOtherInput();


}
