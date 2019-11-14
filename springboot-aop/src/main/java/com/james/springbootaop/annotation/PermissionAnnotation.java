package com.james.springbootaop.annotation;

import java.lang.annotation.*;

/**
 * 权限控制
 *
 * @Author yujie.pan
 * @Date 2019/11/13 10:40
 **/

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PermissionAnnotation {

    PermissionEnum value() default PermissionEnum.DEFAULT;

}
