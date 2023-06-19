package com.whw;

import com.whw.entity.User;
import com.whw.mapper.UserMapper;
import com.whw.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class MyBatisPlusServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testSelect() {
        System.out.println("———查询测试———");
        List<User> userList = userService.list();
        userList.forEach(System.out::println);


    }
}