package com.wang.jmonkey.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description: 注册中心
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
@EnableEurekaServer
@SpringBootApplication
public class JMonkeyEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JMonkeyEurekaApplication.class, args);
    }
}
