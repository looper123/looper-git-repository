package com.quark.cloud.receiver;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by ZhenpengLu on 2017/10/16.
 */
public interface MyOutput {

    String OUTPUT_NAME = "my_channel";

    @Output(MyOutput.OUTPUT_NAME)
    MessageChannel output();
}
