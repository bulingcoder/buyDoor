package com.whw;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.whw.service.GoodsService;
import com.whw.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest
public class DSTest {
    @Autowired
    private UserService userService;

    @Autowired
    private GoodsService goodsService;


    @Test
    public void test() {
        String password = "123456";

        String passwordMd5 = DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println(passwordMd5);
//        System.out.println(userService.getById(1));
//        System.out.println(goodsService.getById(1));

    }

}
