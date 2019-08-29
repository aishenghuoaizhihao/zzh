package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//扫描mapper接口所在的包
@MapperScan("com.example.user.mapper")
public class OneApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneApplication.class, args);
    }

}
