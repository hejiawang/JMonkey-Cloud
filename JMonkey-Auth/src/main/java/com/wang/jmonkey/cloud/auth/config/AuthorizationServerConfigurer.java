package com.wang.jmonkey.cloud.auth.config;

import com.wang.jmonkey.cloud.auth.bean.AuthServerConfig;
import com.wang.jmonkey.cloud.auth.component.JMonkeyWebResponseExceptionTranslator;
import com.wang.jmonkey.cloud.common.constant.CommonConstant;
import com.wang.jmonkey.cloud.common.constant.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @Description: 授权服务器
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
@Configuration
@Order(Integer.MIN_VALUE)
@EnableAuthorizationServer
public class AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthServerConfig authServerConfig;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JMonkeyWebResponseExceptionTranslator webResponseExceptionTranslator;

    /**
     * 配置客户端详情服务
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()  //使用内存来实现客户端详情服务
                .withClient(authServerConfig.getClientId()) //标识客户的Id
                .resourceIds(SecurityConstants.RESOURCE_ID)
                .secret(authServerConfig.getClientSecret()) //（需要值得信任的客户端）客户端安全码，如果有的话
                .authorizedGrantTypes(SecurityConstants.REFRESH_TOKEN, SecurityConstants.PASSWORD,SecurityConstants.AUTHORIZATION_CODE) //此客户端可以使用的授权类型
                .scopes(authServerConfig.getScope());   //用来限制客户端的访问范围，如果为空（默认）的话，那么客户端拥有全部的访问范围
    }

    /**
     * 配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)
     * @param endpoints
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.tokenStore(new RedisTokenStore(redisConnectionFactory))
                .accessTokenConverter(jwtAccessTokenConverter())    //JWT令牌
                .authenticationManager(authenticationManager)   //认证管理器
                .exceptionTranslator(webResponseExceptionTranslator)    //自定义错误处理
                .reuseRefreshTokens(false)
                .userDetailsService(userDetailsService);
    }

    /**
     * 配置令牌端点(Token Endpoint)的安全约束
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .allowFormAuthenticationForClients()
                .tokenKeyAccess("isAuthenticated()")
                .checkTokenAccess("permitAll()");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey(SecurityConstants.JWT_KEY);
        return jwtAccessTokenConverter;
    }
}
