package com.whw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableDiscoveryClient
@EnableFeignClients("com.whw.service.feign")
@SpringBootApplication
public class BuyDoorLoginApplication {

    public static void main(String[] args) {

        SpringApplication.run(BuyDoorLoginApplication.class, args);

    }

}

