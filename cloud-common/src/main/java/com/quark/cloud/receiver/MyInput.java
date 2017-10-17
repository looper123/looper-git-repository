package com.quark.cloud.receiver;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by ZhenpengLu on 2017/10/16.
 */
public interface MyInput {

    String INPUT_NAME="my_channel";

    @Input(MyInput.INPUT_NAME)
    SubscribableChannel input();
}
