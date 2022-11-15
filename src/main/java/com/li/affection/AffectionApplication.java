package com.li.affection;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/li/affection/mapper")
public class AffectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(AffectionApplication.class, args);
    }

}
