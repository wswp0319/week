package com.wp.week.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebappAdapter implements WebMvcConfigurer {

    /**
     * 注册拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        // addPathPatterns 添加拦截url，     excludePathPatterns 排除拦截url
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(loginInterceptor.getUrl());
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}