package com.example.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.example.springbootdemo.bean.BeanA;
import com.example.springbootdemo.bean.ComponentBean;
import com.example.springbootdemo.jms.AMQProducer;
import com.example.springbootdemo.jms.config.ActiveMQConfig;

/**
 * @Project: spring-boot-demo
 * @Author : haihuab
 * @Date : 2021/1/18 15:40
 * @Description: TODO
 */
@SpringBootApplication
public class CLIApp implements CommandLineRunner {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CLIApp.class);

    public static void main(String[] args) {

        new SpringApplicationBuilder(CLIApp.class)
                .build()
                .run(args);
    }

//    @Autowired
//    private ComponentBean comBean;
//
//    @Autowired
//    private BeanA beanA;

    @Autowired
    private AMQProducer amqProducer;

    @Autowired
    private ActiveMQConfig activeMQConfig;

    @Override
    public void run(String... args) throws Exception {
//        comBean.run();
//        beanA.run();
//        for (int i = 0; i < 10; i++) {
//            amqProducer.sendMessageToFirstAMQ(activeMQConfig.nbifileQueue, "hello world", null);
//        }
    }
}
