package com.james.springbootaop.controller;

import com.james.springbootaop.annotation.PermissionAnnotation;
import com.james.springbootaop.annotation.PermissionEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yujie.pan
 * @Date 2019/11/13 10:35
 **/

@RestController
public class MyController {

    @GetMapping("/hello")
    public String hello(Integer id, String name, Integer age) {
        System.out.println("hello方法执行：id==>" + id + "，name==>" + name + "，age==>" + age);
        return "不需要用户权限";
    }

    @GetMapping("/user")
    @PermissionAnnotation
    public String user(Integer id, String name, Integer age) {
        System.out.println("user方法执行：id==>" + id + "，name==>" + name + "，age==>" + age);
        return "已登录";
    }

    @GetMapping("/admin")
    @PermissionAnnotation(value = PermissionEnum.ADMIN)
    public String admin(Integer id, String name, Integer age) {
        System.out.println("admin方法执行：id==>" + id + "，name==>" + name + "，age==>" + age);
        return "权限校验成功";
    }
}
