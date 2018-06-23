package com.wang.jmonkey.cloud.auth.bean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lengleng
 * @date 2018/1/9
 */
@Configuration
@ConditionalOnExpression("!'${JMonkey.urls}'.isEmpty()")
@ConfigurationProperties(prefix = "JMonkey.urls")
public class FilterUrlsPropertiesConifg {
    private List<String> anon = new ArrayList<>();

    public List<String> getAnon() {
        return anon;
    }

    public void setAnon(List<String> anon) {
        this.anon = anon;
    }
}
