package com.changzhen.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: changzhen
 * @Date: 2017/12/23
 * @Time: 上午11:41
 */
@Aspect
@Component
public class TimeAspect {
    @Around("execution(* com.changzhen.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("timeAspect start");
        Object[] objects = proceedingJoinPoint.getArgs();
        for (Object arg :
                objects) {
            System.out.println("arg: " + arg);
        }
        long start = System.currentTimeMillis();

        Object object = proceedingJoinPoint.proceed();

        System.out.println("time aspect is: "+(System.currentTimeMillis()-start));
        System.out.println("timeAspect end");
        return object;
    }
}
