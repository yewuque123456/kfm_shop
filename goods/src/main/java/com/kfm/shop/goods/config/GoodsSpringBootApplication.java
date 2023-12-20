package com.kfm.shop.goods.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.kfm.shop.goods","com.kfm.shop.comm"})
@MapperScan( "com.kfm.shop.goods.mapper")
public class GoodsSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsSpringBootApplication.class, args);
        System.out.println("启动了");
    }
}
