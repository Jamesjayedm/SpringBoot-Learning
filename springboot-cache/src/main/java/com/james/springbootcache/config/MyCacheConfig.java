package com.james.springbootcache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyCacheConfig {

    /**
     * 自定义key生成器,并指定名称
     * @return
     */
    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator() {
        return (o, method, objects) -> method.getName() + "[" + Arrays.asList(objects.toString()) + "]";
    }
}
