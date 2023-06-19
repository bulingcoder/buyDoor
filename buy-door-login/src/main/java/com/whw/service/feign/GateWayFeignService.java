package com.whw.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "buy-door-gateway-service",path ="/gateway" )
public interface GateWayFeignService {
    @RequestMapping("/helloWorld")
    String showHelloWorld ();
}
