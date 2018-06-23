package com.wang.jmonkey.cloud.auth.config;

import com.wang.jmonkey.cloud.auth.bean.FilterUrlsPropertiesConifg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @Description: 认证服务器开放接口配置
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {

    @Autowired
    private FilterUrlsPropertiesConifg filterUrlsPropertiesConifg;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.authorizeRequests();
        filterUrlsPropertiesConifg.getAnon().forEach( url-> registry.antMatchers(url).permitAll() );
        registry.anyRequest().authenticated().and().csrf().disable();
    }
}
