package com.whw.aspect;

import com.whw.annotation.NoRepeatSubmit;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author whw
 * @Title: NoRepeatSubmitAspect
 * @Date 2022/7/19 15:32
 */
@Slf4j
@Aspect
@Component
public class NoRepeatSubmitAspect {

    @Autowired
    private RedisTemplate redisTemplate;
    @Pointcut("@annotation(noRepeatSubmit)")
    public void pointcut(NoRepeatSubmit noRepeatSubmit) {
    }
    @Before("pointcut(noRepeatSubmit)")
    public void before(final JoinPoint joinPoint, NoRepeatSubmit noRepeatSubmit) throws Exception {
        log.info("joinPoint:"+joinPoint);

        //获取目标类的名称
        String target = joinPoint.getTarget().getClass().getName();
        //获取目标类的方法
        String methodName = joinPoint.getSignature().getName();
        log.info("target:"+target);
        log.info("methodName:"+methodName);

        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        log.info("request:"+request);
        String url = request.getRequestURL().toString();
        log.info("url:"+url);
        String token = request.getHeader("token");
        log.info("token:"+token);

        //自行定义符合业务需要的key
        String redisKey = target+"_"+methodName+"_"+token;
        if ( redisTemplate.hasKey(redisKey)) {
            throw new Exception( "请勿重复提交");
        }else {
            //此处设置的1秒过期
            redisTemplate.opsForValue().set(redisKey, "不要重复提交！！！",5000, TimeUnit.MILLISECONDS);
            log.info("value:::::"+redisTemplate.opsForValue().get(redisKey));
        }
    }
}
