package com.wang.jmonkey.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @Description: 服务网关
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan(basePackages = {"com.wang.jmonkey.cloud.gateway", "com.wang.jmonkey.cloud.common"})
public class JMonkeyGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(JMonkeyGatewayApplication.class, args);
    }
}
