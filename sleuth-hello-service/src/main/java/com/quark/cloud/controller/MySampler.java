//package com.quark.cloud.controller;
//
//import org.springframework.cloud.sleuth.Sampler;
//import org.springframework.cloud.sleuth.Span;
//
///**
// * Created by ZhenpengLu on 2017/10/20.
// * 自定义sampler 对需要被跟踪系统跟踪的信息自定义处理方式
// */
//public class MySampler implements Sampler {
//
//
//    private String tag;
//
//    public MySampler(String tags) {
//        this.tag = tag;
//    }
//
//    @Override
//    public boolean isSampled(Span span) {
//        return span.tags().get(tag) != null;
//    }
//}
