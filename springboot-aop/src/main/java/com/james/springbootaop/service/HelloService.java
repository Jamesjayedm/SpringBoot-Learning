package com.james.springbootaop.service;

/**
 * @Author yujie.pan
 * @Date 2019/11/13 14:33
 **/

public interface HelloService {

    void sayHello();

    void say(String msg);

    void err(boolean isThrow);

}
