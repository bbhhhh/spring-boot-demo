package com.example.springbootdemo.sink;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: spring-boot-demo
 * @Author : haihuab
 * @Date : 2023/1/13 16:53
 * @Description:
 */

@Slf4j
public class AlarmMsgSink {
    public static void log(String data) {
        log.info(data);
    }
}
