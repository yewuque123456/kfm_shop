package com.kfm.comm;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan( "com.kfm.comm.mapper")
public class SystemSpringBootApplication {
    public static void main(String[] args) {
       SpringApplication.run(SystemSpringBootApplication.class, args);
        System.out.println("GoodsSpringBootApplication 项目启动成功");
    }
}
