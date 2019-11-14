package com.james.springbootaop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yujie.pan
 * @Description: 统一日志处理
 * @date 2019/1/28 11:40
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(public * com.james.springbootaop.controller.*.*(..))")
    public void log() {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();

        // url
        log.info("url->{}", request.getRequestURL());
        // ip
        log.info("IP->{}", request.getRemoteAddr());
        // 类方法
        log.info("class_method->{}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 参数
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < joinPoint.getArgs().length; i++) {
            sb.append(joinPoint.getArgs()[i]);
            if (i != joinPoint.getArgs().length - 1) {
                sb.append(",");
            }
        }
        log.info("args->{}", sb.toString());
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(JoinPoint joinPoint, Object object) {
        log.info("{}.{} response->{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), object);
    }

    @Pointcut("@annotation(com.james.springbootaop.annotation.ServiceLog)")
    public void serviceLog() {
    }

    /**
     * 服务层debug log
     *
     * @param joinPoint 切点
     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "serviceLog()")
    public void serviceDebugLog(JoinPoint joinPoint, Object object) {
        log.debug("{}.{} result->{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), object);
    }
}
