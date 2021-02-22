package com.example.springbootdemo.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Project: spring-boot-demo
 * @Author : haihuab
 * @Date : 2021/1/18 15:37
 * @Description: TODO
 */

@Component
public class ComponentBean {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ComponentBean.class);

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
