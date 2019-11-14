package com.james.springbootaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author yujie.pan
 * @Date 2019/11/14 10:16
 **/
@Aspect
@Component
public class ServiceAspect {
    // 切点范围
    @Pointcut("execution(* com.james.springbootaop.service..*(..))")
    public void pointcut(){ }

    @Before("pointcut()")
    public void before() {
        System.out.println("---------------@Before----------------");
    }

    @AfterReturning("pointcut()")
    public void afterReturning() {
        System.out.println("---------------@AfterReturning----------------");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("---------------@After----------------");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("---------------@AfterThrowing----------------");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object result;
        System.out.println("---------------@Around前----------------");
        try {
            result = pjp.proceed();
        } catch (Throwable throwable) {
            System.out.println("---------------@Around异常----------------");
            // 监听参数为true则抛出异常，为false则捕获并不抛出异常
            if (pjp.getArgs().length > 0 && !(Boolean) pjp.getArgs()[0]) {
                result = null;
            } else {
                throw throwable;
            }
        }
        System.out.println("---------------@Around后----------------");
        return result;
    }

}
