package com.whw.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum SexEnum {
    /**
     *
     */
    MALE(1, "男"),
    FEMALE(2, "女");

    // 将注解所标识的属性值保存到数据库中
    @EnumValue
    private Integer sex;

    private String sexname;


    SexEnum(Integer sex, String sexname) {
        this.sex = sex;
        this.sexname = sexname;
    }

}
