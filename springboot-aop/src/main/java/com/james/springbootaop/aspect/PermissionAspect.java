package com.james.springbootaop.aspect;

import com.james.springbootaop.annotation.PermissionAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * AOP切面类
 *
 * @Pointcut 用来定义切点，针对方法
 * @Aspect 用来定义切面，针对类
 *
 * @Author yujie.pan
 * @Date 2019/11/13 11:41
 **/

@Aspect
@Component
public class PermissionAspect {

    @Pointcut("@annotation(pa)")
    public void Permission(PermissionAnnotation pa) {}

    @Around("Permission(pa)")
    public Object doAround(ProceedingJoinPoint joinPoint, PermissionAnnotation pa) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String permission = pa.value().getId();
        if (permission.equals("0")) {
            String id = request.getHeader("id");
            if (id != null && !id.equals("")) {
                // 已登录，执行原方法并返回即可。
                return joinPoint.proceed();
            }
            // 未登录，不执行方法，直接返回错误信息
            return "请登录！";
        } else {
            String role = request.getHeader("role");
            if (role != null && role.equals(permission)) {
                return joinPoint.proceed();
            }
            return "权限校验失败";
        }

        /*System.out.println("------------方法执行之前------------");
        // 执行原方法，并记录返回值。
        Object proceed = joinPoint.proceed();
        System.out.println("------------方法执行之后------------");
        return proceed;*/
    }

}
