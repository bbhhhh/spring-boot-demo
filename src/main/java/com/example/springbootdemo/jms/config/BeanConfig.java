package com.example.springbootdemo.jms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.springbootdemo.bean.ComponentBean;
import com.example.springbootdemo.bean.SubComponent;

/**
 * @Project: spring-boot-demo
 * @Author : haihuab
 * @Date : 2021/1/18 16:15
 * @Description: TODO
 */

@Configuration
public class BeanConfig {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(BeanConfig.class);

//    @Bean
//    public ComponentBean componentBean(SubComponent subComponent) {
//        return new ComponentBean(subComponent);
//    }
}
