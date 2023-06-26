package com.whw.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class HelloWorldJobController {

   @RequestMapping("/helloWorld")
    public String showHelloWorld () {
        System.out.println("open fengin 调用成功");
        return "HelloWorld:9000";
    }
}
