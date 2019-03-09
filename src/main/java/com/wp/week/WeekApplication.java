package com.wp.week;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@MapperScan("com.wp.week.mapper")
public class WeekApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeekApplication.class, args);
    }
}
