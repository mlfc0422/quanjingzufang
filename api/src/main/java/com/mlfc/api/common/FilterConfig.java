package com.mlfc.api.common;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class FilterConfig {
//
//
//    @Bean(name = "jjwtFilter")
//    public FilterRegistrationBean<JwtFilter> jwtFilter() {
//        FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new JwtFilter());
//        registrationBean.addUrlPatterns("/*"); // 配置拦截的 URL 模式
//        registrationBean.setOrder(1); // 设置优先级，值越小优先级越高
//        return registrationBean;
//    }
//}
