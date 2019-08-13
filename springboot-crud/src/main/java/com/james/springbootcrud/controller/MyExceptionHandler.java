package com.james.springbootcrud.controller;

import com.james.springbootcrud.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 定制错误响应
 * 浏览器返回error页面，其他客户端返回json
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        // 传入错误状态码
        request.setAttribute("javax.servlet.error.status_code", 500);
        map.put("code", "user.notexist");
        map.put("msg", e.getMessage());

        request.setAttribute("ext", map);
        // 转发到/error
        return "forward:/error";
    }
}
