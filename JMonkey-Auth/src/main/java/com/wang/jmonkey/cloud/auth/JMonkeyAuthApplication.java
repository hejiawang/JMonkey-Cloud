package com.wang.jmonkey.cloud.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @Description: 授权服务
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableResourceServer
public class JMonkeyAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(JMonkeyAuthApplication.class, args);
    }
}
