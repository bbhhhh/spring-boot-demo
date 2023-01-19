package com.example.springbootdemo.config;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

/**
 * @Project: spring-boot-demo
 * @Author : haihuab
 * @Date : 2022/12/15 15:30
 * @Description:
 */

@Component
@Getter
public class CommonConfig {

    @Value("${province_code:'047'}")
    private String provinceCode ;

    @Value("${protocol_version:'V3.0.0'}")
    private String protocolVersion ;

    @Value("${default_dpi_provider:'1'}")
    private String dpiProvider ;

    public static final DateTimeFormatter EVENT_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmmss");
    public static final ZoneOffset LocalZoneOffset = ZoneOffset.ofHours(8);
    public static final String TempFieldSeparator = "^^" ;
    public static final String FormalFieldSeparator = "|" ;

}
