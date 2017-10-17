//package com.quark.cloud.receiver;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.Input;
//import org.springframework.cloud.stream.annotation.Output;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.cloud.stream.messaging.Processor;
//import org.springframework.cloud.stream.reactive.FluxSender;
//import org.springframework.cloud.stream.reactive.ObservableSender;
//import org.springframework.messaging.handler.annotation.SendTo;
//import reactor.core.publisher.Flux;
//import rx.Observable;
//
///**
// * Created by ZhenpengLu on 2017/10/16.
// */
//@EnableBinding(Processor.class)
//@EnableAutoConfiguration
//public  class UppercaseTransformer {
//
//    private static Logger  LOGGER = LoggerFactory.getLogger(UppercaseTransformer.class);
//
////    @StreamListener(value = Processor.INPUT)
//////    把返回结果 发送给通道入口
////    @SendTo(value =Processor.OUTPUT)
////    public String channelInteractive(String message) {
////        String s = null;
////        LOGGER.info("hello service--------get input" + message);
////        return "hello service------put output";
////    }
//
////    效果同上
////    @StreamListener
////    public void receive(@Input(Processor.INPUT) Flux<String> input,
////                        @Output(Processor.OUTPUT) FluxSender output) {
//////        output.send 以外的操作只执行一次
////        LOGGER.info("initialize input----output"+input+"----"+output);
//////        output.send(input.map(s -> s.toUpperCase()));
//////        output.send 中的操作 每发送一次消息会随之执行一次
//////        以下效果：output通道中攒5条信息后再发送
////        output.send( input.map(strings -> toString().toUpperCase()).buffer(5) ) ;
////    }
//
////    @StreamListener
////    @Output(Processor.OUTPUT)
//////    reactor-core 版本必须>=3.0.4.RELEASE
////    public Flux<String> receive(@Input(Processor.INPUT) Flux<String> input) {
////        return input.map(s -> s.toUpperCase());
////    }
////
//
////    rxjava 1.x版本 使用 Observable 和 ObservableSender 作为参数
////    @StreamListener
////    @Output(Processor.OUTPUT)
////    public Observable<String> receive(@Input(Processor.INPUT) Observable<String> input) {
////        return input.map(s -> s.toUpperCase());
////    }
////
////    @StreamListener
////    public void receive(@Input(Processor.INPUT) Observable<String> input,
////                        @Output(Processor.OUTPUT) ObservableSender output) {
////        output.send(input.map(s -> s.toUpperCase()));
////    }
//
//
//}
