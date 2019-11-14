package com.james.springbootaop.service.impl;

import com.james.springbootaop.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @Author yujie.pan
 * @Date 2019/11/13 14:33
 **/
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello() {
        System.out.println("Hello");
    }

    @Override
    public void say(String msg) {
        System.out.println(msg);
    }

    @Override
    public void err(boolean isThrow) {
        System.out.println("error begin");
        throw new RuntimeException("Runtime error");
    }
}
