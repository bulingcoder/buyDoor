package com.whw.controller;

import com.whw.service.feign.GateWayFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope
@RestController // @Controller + @ ResponseBody 直接返回字符串
public class HelloWorldController {

    @Autowired
    private GateWayFeignService gateWayFeignService;

    /**
     * 应用ID
     */
    @Value("${wechatpayment.mchid}")
    private String mchid;

    @RequestMapping("/helloWorld")
    public String showHelloWorld () {

        System.out.println("mchAppid:"+mchid);
        return "HelloWorld:8080---"+mchid;
    }

    @RequestMapping("/feiHelloWorld")
    public String feiHelloWorld () {
      return gateWayFeignService.showHelloWorld();
    }
}
