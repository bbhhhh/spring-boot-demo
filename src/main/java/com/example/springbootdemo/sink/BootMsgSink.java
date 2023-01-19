package com.example.springbootdemo.sink;

import lombok.extern.slf4j.Slf4j;

/**
 * @Project: spring-boot-demo
 * @Author : haihuab
 * @Date : 2023/1/13 16:50
 * @Description:
 */

@Slf4j
public class BootMsgSink {
    public static void log(String data) {
        log.info(data);
    }
}
