package com.example.springbootdemo.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Project: spring-boot-demo
 * @Author : haihuab
 * @Date : 2021/1/20 8:52
 * @Description: TODO
 */
@Component
public class BeanA {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(BeanA.class);

    @Autowired
    private SubComponent subComponent;

    public void run() {
        if (this.subComponent == null) {
            logger.warn("subComponent is null");
        } else {
            this.subComponent.run();
        }
        logger.info("{} running.", this.getClass().getSimpleName());
    }
}
