package com.example.springbootdemo.bean;

import org.springframework.stereotype.Component;

/**
 * @Project: spring-boot-demo
 * @Author : haihuab
 * @Date : 2021/1/18 16:20
 * @Description: TODO
 */

@Component
public class SubComponent {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(SubComponent.class);

    public void run() {
        logger.info("{} running, object={}.", this.getClass().getSimpleName(), this);
    }
}
