package com.example.springbootdemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        String propLocation = "spring.config.additional-location:file:" + System.getProperty("conf.dir")
                + "/application.properties";

        new SpringApplicationBuilder(SpringBootDemoApplication.class)
                .properties(propLocation)
                .build()
                .run(args);
//        SpringApplication.run(SpringBootDemoApplication.class, args);
    }


}
