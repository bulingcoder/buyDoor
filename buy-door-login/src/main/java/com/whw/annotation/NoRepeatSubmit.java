package com.whw.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description:防止重复提交
 * @Author whw
 * @Title: NoRepeatSubmit
 * @Date 2022/7/19 15:26
 */
// 作用到方法上
@Target(ElementType.METHOD)
// 运行时有效
@Retention(RetentionPolicy.RUNTIME)
public @interface NoRepeatSubmit {
    /**
     * 默认时间3秒
     */
    int time() default 3 * 1000;
}

