package com.wang.jmonkey.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Description: 服务网关
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
@EnableZuulProxy
@SpringCloudApplication
public class JMonkeyGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(JMonkeyGatewayApplication.class, args);
    }
}
