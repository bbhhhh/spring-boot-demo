package com.example.springbootdemo.bean;

import org.springframework.context.annotation.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Project: spring-boot-demo
 * @Author : haihuab
 * @Date : 2021/12/12 20:10
 * @Description: TODO
 */

@Data
@AllArgsConstructor
public class User {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(User.class);

    private String id ;
    private String name ;
    private int age ;
    private int gender ;

}
