package com.wang.jmonkey.cloud.gateway.componet.config;

import com.wang.jmonkey.cloud.common.component.bean.FilterUrlsPropertiesConfig;
import com.wang.jmonkey.cloud.gateway.componet.filter.ValidateCodeFilter;
import com.wang.jmonkey.cloud.gateway.componet.handler.JMonkeyAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Description: 配置资源服务器
 * @Auther: HeJiawang
 * @Date: 2018/6/24
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {

    @Autowired
    private OAuth2WebSecurityExpressionHandler expressionHandler;

    @Autowired
    private JMonkeyAccessDeniedHandler accessDeniedHandler;

    //@Autowired
    //private ValidateCodeFilter validateCodeFilter;

    @Autowired
    private FilterUrlsPropertiesConfig filterUrlsPropertiesConifg;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class);
        http.headers().frameOptions().disable();    //允许使用iframe 嵌套，避免swagger-ui 不被加载的问题

        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.authorizeRequests();
        for (String url : filterUrlsPropertiesConifg.getAnon()) {
            registry.antMatchers(url).permitAll();
        }
        registry.anyRequest().access("@permissionService.hasPermission(request,authentication)");
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        //resources.resourceId(SecurityConstants.RESOURCE_ID).stateless(true);
        resources.expressionHandler(expressionHandler);
        resources.accessDeniedHandler(accessDeniedHandler);
    }

    /**
     * 配置解决 spring-security-oauth问题
     * https://github.com/spring-projects/spring-security-oauth/issues/730
     *
     * @param applicationContext ApplicationContext
     * @return OAuth2WebSecurityExpressionHandler
     */
    @Bean
    public OAuth2WebSecurityExpressionHandler oAuth2WebSecurityExpressionHandler(ApplicationContext applicationContext) {
        OAuth2WebSecurityExpressionHandler expressionHandler = new OAuth2WebSecurityExpressionHandler();
        expressionHandler.setApplicationContext(applicationContext);
        return expressionHandler;
    }

    /**
     * 加密方式
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
