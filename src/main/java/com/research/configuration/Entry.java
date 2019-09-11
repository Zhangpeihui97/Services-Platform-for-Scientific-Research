package com.research.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.research")
@MapperScan(basePackages = "com.research.dao")
public class Entry{
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Entry.class, args);
    }

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
//        return builder.sources(Entry.class);
//    }
}
