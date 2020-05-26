package com.heu.lanke.scra;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.heu.lanke.scra.dao")
public class ScraApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScraApplication.class, args);
    }

}
