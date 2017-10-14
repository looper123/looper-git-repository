package com.quark.cloud.receiver;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * Created by ZhenpengLu on 2017/10/13.
 * 自定义消息通道接口 - 出口
 */
public interface MySource {

    String CHANNEL_NAME = "customer_channel";

    @Output(MySource.CHANNEL_NAME)
//    返回值固定 MessageChannel 定义了维护消息通道发布者的方法
    MessageChannel MyOutput();
}
