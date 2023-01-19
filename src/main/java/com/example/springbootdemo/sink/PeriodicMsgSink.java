package com.example.springbootdemo.sink;

import com.example.springbootdemo.pojo.PeriodicMessage;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: spring-boot-demo
 * @Author : haihuab
 * @Date : 2022/12/14 15:29
 * @Description:
 */

@Slf4j
public class PeriodicMsgSink {
    public static void log(String data) {
        log.info(data);
    }

}
