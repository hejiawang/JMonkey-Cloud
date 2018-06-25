package com.wang.jmonkey.cloud.modules.upms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description: 通用用户权限管理系统
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.wang.jmonkey.cloud"})
@MapperScan(basePackages = {"com.wang.jmonkey.cloud.modules.*.mapper"})
public class JMonkeyUPMSApplication {

    public static void main(String[] args) {
        SpringApplication.run(JMonkeyUPMSApplication.class, args);
    }
}
