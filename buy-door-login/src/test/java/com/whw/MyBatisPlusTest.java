package com.whw;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whw.entity.Product;
import com.whw.entity.User;
import com.whw.enums.SexEnum;
import com.whw.mapper.ProductMapper;
import com.whw.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;
import java.util.Map;

@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void testProduct01() {
        // 小李查询商品价格
        Product productLi = productMapper.selectById(1);
        System.out.println("小李查询的商品价格：" + productLi.getPrice());

        // 小王查询商品价格
        Product productWang = productMapper.selectById(1);
        System.out.println("小王查询的商品价格：" + productWang.getPrice());

        // 小李将商品价格+50
        productLi.setPrice(productLi.getPrice() + 50);
        productMapper.updateById(productLi);

        // 小王将商品的价格-30
        productWang.setPrice(productWang.getPrice() - 30);
        int result = productMapper.updateById(productWang);
        if (result == 0) {
            // 操作失败，重试
            System.out.println("into 操作失败，重试");
            Product productNew = productMapper.selectById(1);
            productNew.setPrice(productNew.getPrice() - 30);
            productMapper.updateById(productNew);

        }

        // 老板查询商品价格
        Product productBOSS = productMapper.selectById(1);
        System.out.println("老板查询的商品价格：" + productBOSS.getPrice());
    }



    @Test
    public void testSelect() {
        System.out.println("———查询测试———");

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("name","age");
        queryWrapper.eq("name","Jack");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);

        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.set("name","Jack5");
        String name = "Jack";
        updateWrapper.eq(StringUtils.isNotBlank(name),"name","Jack");
        userMapper.update(null, updateWrapper);

//
//        List<Map<String, Object>> userMaps = userMapper.selectMaps(null);
//        System.out.println("userMaps:"+userMaps);
//        System.out.println("userMaps:"+userMaps.get(0).get("name"));
//
//        System.out.println("selectMapById:"+userMapper.selectMapById(4L));
    }

    @Test
    public void testPage(){

        Page<User> userPage = new Page<>(2,2);

        userMapper.selectPage(userPage, null);
        System.out.println("userPage:"+userPage.getRecords());
    }

    @Test
    public void testEnum() {
        User user = new User();
        user.setName("admin");
        user.setAge(33);
        user.setSex(SexEnum.MALE);
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void testInsertFieldFill() {
        User user = new User();
        user.setName("FieldFill");
        user.setAge(44);
        user.setSex(SexEnum.FEMALE);
        int insert = userMapper.insert(user);
        System.out.println(insert);

    }

    @Test
    public void testUpdateFieldFill() {
        User user = new User();
        user.setName("FieldFill2");
        user.setAge(55);
        user.setId(5L);
        int insert = userMapper.updateById(user);
        System.out.println(insert);

    }


}