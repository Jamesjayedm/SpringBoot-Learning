package com.james.springbootcrud.config;

import com.james.springbootcrud.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/james").setViewName("success");
    }

    /**
     * 所有的WebMvcConfigurer都会一起起作用，所以可以一起返回
     */
    @Bean //必须要注册到容器中,否则用的是springmvc自己的
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            // 加入视图映射
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            // 注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
//                // 排除几个登录的请求，且SpringBoot已经做好了静态资源的映射，不用考虑
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/", "/index.html", "/user/login");
            }
        };
        return webMvcConfigurer;
    }

    /**
     * 将自己配置的localResolver添加到容器中，如果不加这个组件，则用的是容器原本自动添加的localResolver
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
