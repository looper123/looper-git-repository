package com.quark.cloud.receiver;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;

import java.util.List;

/**
 * Created by ZhenpengLu on 2017/10/16.
 */
@EnableBinding(Processor.class)
@EnableAutoConfiguration
public  class UppercaseTransformer {

    @StreamListener
    @Output(Processor.OUTPUT)
    public List<String> receive(@Input(Processor.INPUT) List<String> input) {
        return input.map(s -> s.toUpperCase());
    }
}
