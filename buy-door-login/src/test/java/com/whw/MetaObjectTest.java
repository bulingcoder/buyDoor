package com.whw;

import com.alibaba.fastjson.JSON;
import com.whw.entity.User;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

public class MetaObjectTest {

    public static void main(String[] args) {

        //第一次读取
        User user = new User();
        user.setName("mary");
        MetaObject metaObject = SystemMetaObject.forObject(user);

        System.out.println("get方法返回类型：" + JSON.toJSONString(metaObject.getGetterType("name")));
        System.out.println("set方法参数类型：" + JSON.toJSONString(metaObject.getSetterType("name")));
        System.out.println("getGetterNames：" + JSON.toJSONString(metaObject.getGetterNames()));
        System.out.println("getSetterNames：" + JSON.toJSONString(metaObject.getSetterNames()));
        System.out.println("name的hasGetter：" + metaObject.hasGetter("name"));
        System.out.println("获取name的属性值：" + metaObject.getValue("name"));
        System.out.println("metaObject.metaObjectForProperty()：" + metaObject.metaObjectForProperty("name"));
        System.out.println("metaObject.findProperty();：" +metaObject.findProperty("name",true));
        System.out.println("metaObject.getObjectFactory();：" +metaObject.getObjectFactory());
        System.out.println("metaObject.getObjectWrapper();：" +metaObject.getObjectWrapper());
        System.out.println("metaObject.getObjectWrapperFactory()：" + metaObject.getObjectWrapperFactory());
        System.out.println("metaObject.getOriginalObject()：" + metaObject.getOriginalObject());
        System.out.println("metaObject.getReflectorFactory()：" + metaObject.getReflectorFactory());
        System.out.println("metaObject.isCollection()：" + metaObject.isCollection());
    }
}
