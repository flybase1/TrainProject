package com.example.project05;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.project05.mapper")
@SpringBootApplication
public class Project05Application {

    public static void main(String[] args) {
        SpringApplication.run(Project05Application.class, args);
    }

}
