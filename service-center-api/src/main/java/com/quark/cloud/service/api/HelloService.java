package com.quark.cloud.service.api;

import com.quark.cloud.entity.UserEntity;
import com.quark.cloud.service.HelloServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ZhenpengLu on 2017/9/29.
 * for feign  test
 */
//@FeignClient(value = "SAMPLE",configuration = HystrixDisabledConfig.class)
@FeignClient(value = "SAMPLE",fallback = HelloServiceFallback.class)//指定降级的类
//@FeignClient(value = "SAMPLE",fallbackFactory =HelloService.HystrixClientFallbackFactory.class)//指定降级的类
public interface HelloService {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String hello();

    @RequestMapping(value ="/hello1",method = RequestMethod.GET)
    String hello1(@RequestParam("name") String name);

    @RequestMapping(value ="/hello2",method = RequestMethod.GET)
    UserEntity hello2(@RequestHeader("name") String name, @RequestHeader("age") String age);

    @RequestMapping(value ="/hello3",method = RequestMethod.POST)
     String hello3(@RequestBody UserEntity userEntity);


//    @Component
//    static class HystrixClientFallback implements HelloService {
//        @Override
//        public String hello() {
//            return "fallback";
//        }
//
//        @Override
//        public String hello1(@RequestParam("name") String name) {
//            return "fallback1";
//        }
//
//        @Override
//        public UserEntity hello2(@RequestHeader("name") String name, @RequestHeader("age") String age) {
//            return new UserEntity("fallback2","fallback2");
//        }
//
//        @Override
//        public String hello3(@RequestBody UserEntity userEntity) {
//            return "fallback3";
//        }
//    }

    //fallbackfactory
//    @Component
//    static class HystrixClientFallbackFactory implements FallbackFactory<HelloService> {
//        @Override
//        public HelloService create(Throwable cause) {
//            return new HelloService(){
//                @Override
//                public String hello() {
//                    return "fallback; reason was: " + cause.getMessage();
//                }
//
//                @Override
//                public String hello1(@RequestParam("name") String name) {
//                    return "fallback1; reason was: " + cause.getMessage();
//                }
//
//                @Override
//                public UserEntity hello2(@RequestHeader("name") String name, @RequestHeader("age") String age) {
//                    return new UserEntity("fallback2","fallback2");
//                }
//
//                @Override
//                public String hello3(@RequestBody UserEntity userEntity) {
//                    return "fallback3; reason was: " + cause.getMessage();
//                }
//            };
//        }
//    }
}
