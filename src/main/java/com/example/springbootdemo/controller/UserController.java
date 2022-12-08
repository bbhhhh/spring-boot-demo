package com.example.springbootdemo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootdemo.bean.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @Project: spring-boot-demo
 * @Author : haihuab
 * @Date : 2021/12/12 20:08
 * @Description: TODO
 */

@RestController
@RequestMapping("/user")
//说明接口文件
@Tag(name = "测试接口", description = "用户测试接口")
public class UserController {
    /**
     * 保存数据
     * @param user
     * @return
     */
    @PostMapping(value = "save",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    //方法参数说明，name参数名；value参数说明，备注；dataType参数类型；required 是否必传；defaultValue 默认值
//    @ApiImplicitParam(name = "user", value = "新增用户数据")
    //说明是什么方法(可以理解为方法注释)
    @Operation(summary = "添加用户")
    public User saveUser(@RequestBody User user){
        return user;
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "根据id获取用户信息", description = "根据id查询用户信息")
    public User getUser(@PathVariable("id") String id){
        User user = new User();
        user.setAge(20);
        user.setBirthDay(new Date());
        user.setGender(1);
        user.setId(id);
        user.setName("zhangsan");
        return user ;
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "根据id删除数据", description = "删除用户")
    public String delete(@PathVariable("id") String id){
        return "{\"result\": \"success\"}";
    }
}