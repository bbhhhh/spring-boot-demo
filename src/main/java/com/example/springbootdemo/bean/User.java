package com.example.springbootdemo.bean;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Project: spring-boot-demo
 * @Author : haihuab
 * @Date : 2021/12/12 20:10
 * @Description: TODO
 */

@Data
public class User {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(User.class);

    private String id ;
    private String name ;
    @Schema(example = "20")
    @Min(0)
    private int age ;
    private int gender ;

    @Schema(example = "2010-01-01 10:00:00")
    @Future
    private Date birthDay ;

}
