package com.kfm.shop;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(scanBasePackages = {"com.kfm.shop.system", "com.kfm.shop.comm"})
@MapperScan( "com.kfm.shop.system.mapper")
@EnableAspectJAutoProxy  //开启aop
public class SystemSpringBootApplication {
    public static void main(String[] args) {
       SpringApplication.run(SystemSpringBootApplication.class, args);
        System.out.println("SystemSpringBootApplication 项目启动成功");
    }
}
