package com.kfm.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
@MapperScan( "com.kfm.shop.mapper")
public class GoodsSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsSpringBootApplication.class, args);
        System.out.println("启动了");
    }
}
