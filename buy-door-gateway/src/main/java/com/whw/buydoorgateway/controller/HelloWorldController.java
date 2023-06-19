package com.whw.buydoorgateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ ResponseBody 直接返回字符串
@RequestMapping("/gateway")
public class HelloWorldController {

   @RequestMapping("/helloWorld")
    public String showHelloWorld () {

        return "HelloWorld:9000";
    }
}
