package com.sweetfun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sweetfun.dao")
public class MyblogServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyblogServerApplication.class, args);
    }
}
