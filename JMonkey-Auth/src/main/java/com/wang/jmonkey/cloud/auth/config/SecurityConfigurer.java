package com.wang.jmonkey.cloud.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @Description:
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
@Configuration
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    protected UserDetailsService userDetailsService(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String finalPassword = "{bcrypt}"+bCryptPasswordEncoder.encode("123456");
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user_1").password(finalPassword).authorities("USER").build());
        manager.createUser(User.withUsername("user_2").password(finalPassword).authorities("USER").build());
        return manager;
    }

    /*@Bean
    PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }*/
}
