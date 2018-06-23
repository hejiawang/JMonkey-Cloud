package com.wang.jmonkey.cloud.auth.config;

import com.wang.jmonkey.cloud.auth.bean.AuthServerConfig;
import com.wang.jmonkey.cloud.common.constant.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @Description: 认证服务器
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

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient(authServerConfig.getClientId())
                .secret(authServerConfig.getClientSecret())
                .authorizedGrantTypes(SecurityConstants.REFRESH_TOKEN, SecurityConstants.PASSWORD,SecurityConstants.AUTHORIZATION_CODE)
                .scopes(authServerConfig.getScope());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
                .tokenStore(new RedisTokenStore(redisConnectionFactory))
                //.accessTokenConverter(jwtAccessTokenConverter())
                .authenticationManager(authenticationManager);
                //.exceptionTranslator(pigWebResponseExceptionTranslator)
                //.reuseRefreshTokens(false)
                //.userDetailsService(userDetailsService);
    }
}
