package com.quark.cloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZhenpengLu on 2017/10/21.
 */
@RestController
public class HomeController {

    @RequestMapping(value = "home")
    public String home() {
        return "home";
    }
}
