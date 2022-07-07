package com.wx.config.aspect;

import java.util.Objects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.wx.utils.TrimUtil;

@Aspect
@Component
public class TrimAspect {
    @Pointcut("execution(public * com.wx..*.*Controller.*(..))")
    public void stringPointCut() {

    }

    @Before("stringPointCut()")
    public Object doAround(JoinPoint joinPoint) throws Throwable {
        Object[] objs = joinPoint.getArgs();
        if (Objects.nonNull(objs) && objs.length > 0) {
            for (int i = 0, len = objs.length; i < len; i++) {
                objs[i] = TrimUtil.trimObjectStringProperty(objs[i]);
            }
        }
        return objs;
    }
}
