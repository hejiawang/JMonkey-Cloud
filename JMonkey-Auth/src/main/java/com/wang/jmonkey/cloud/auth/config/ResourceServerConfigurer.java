package com.wang.jmonkey.cloud.auth.config;

import com.wang.jmonkey.cloud.common.component.bean.FilterUrlsPropertiesConifg;
import com.wang.jmonkey.cloud.common.constant.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @Description: 配置资源服务器
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

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(SecurityConstants.RESOURCE_ID).stateless(true);
    }
}
