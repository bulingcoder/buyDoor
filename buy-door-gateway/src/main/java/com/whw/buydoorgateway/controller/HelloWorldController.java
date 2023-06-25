package com.whw.buydoorgateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ ResponseBody 直接返回字符串
@RequestMapping("/gateway")
public class HelloWorldController {

   @RequestMapping("/helloWorld")
    public String showHelloWorld () {
        System.out.println("open fengin 调用成功");
        return "HelloWorld:9000";
    }
}
