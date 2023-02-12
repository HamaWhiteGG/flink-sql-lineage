package com.lineage.server.interfaces.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @description: ControllerAspect
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/12 9:51 PM
 */
@Aspect
@Component
public class ControllerAspect {
    private static final Logger LOG = LoggerFactory.getLogger(ControllerAspect.class);

    @Around("execution(* com.lineage.server.interfaces.controller..*.*(..)) ")
    public Object interceptor(ProceedingJoinPoint pjp) throws Throwable {
        long beginTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) pjp.getSignature();

        if (signature.getMethod().getAnnotation(SkipAspect.class) != null) {
            return pjp.proceed();
        }
        String method = signature.getMethod().getName();
        LOG.info("method: {}, param: {}", method, pjp.getArgs());
        Object result = pjp.proceed();
        long time = System.currentTimeMillis() - beginTime;
        LOG.info("method: {}, param: {}, result: {}, time: {} ms", method, pjp.getArgs(), result, time);
        return result;
    }
}
