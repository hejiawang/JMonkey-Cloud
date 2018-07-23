package com.wang.jmonkey.cloud.modules.upms.generator;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Auther: HeJiawang
 * @Date: 2018/7/23
 */
public class CodeGeneratorCustomTemplate {

    /**
     * 是否强制带上注解
     */
    boolean enableTableFieldAnnotation = false;
    /**
     * 生成的注解带上IdType类型
     */
    IdType tableIdType = null;
    /**
     * 是否去掉生成实体的属性名前缀
     */
    String[] fieldPrefix = null;
    /**
     * 生成的Service 接口类名是否以I开头
     * 默认是以I开头
     * user表 -> IUserService, UserServiceImpl
     */
    boolean serviceClassNameStartWithI = true;

    private void generateByTablesWithInjectConfig(String packageName, String... tableNames) {
        GlobalConfig config = new GlobalConfig();
        config.setControllerName("%sApi");



        String dbUrl = "jdbc:mysql://114.116.89.11:3306/hjw_test?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("123456")
                .setDriverName("com.mysql.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setVersionFieldName("version")
                .setCapitalMode(true)
                .setEntityLombokModel(false)
                .setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .entityTableFieldAnnotationEnable(enableTableFieldAnnotation)
                .setSuperControllerClass("com.wang.jmonkey.cloud.common.http.abs.BaseHttp")
                .setEntityLombokModel(true).setSuperEntityClass("com.wang.jmonkey.cloud.common.model.BaseEntity")
                .fieldPrefix(fieldPrefix)//test_id -> id, test_type -> type
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        config.setActiveRecord(false)
                .setIdType(tableIdType)
                .setAuthor("K神带你飞")
                .setBaseResultMap(true)
                .setOutputDir("D:/CodeGenerator")
                .setFileOverride(true);
        if (!serviceClassNameStartWithI) {
            config.setServiceName("%sService");
        }
        TemplateConfig templateConfig = new TemplateConfig()
                .setXml("/templates/mapper2.xml").setController("/templates/Api.java");
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {//自定义参数
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        new AutoGenerator().setGlobalConfig(config)
                .setTemplate(templateConfig)//自定义模板路径
                .setCfg(injectionConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setController("api")
                                .setEntity("model.entity")
                ).execute();
    }


    @Test
    public void codeGeneratorTest(){
        String packageName = "com.baomidou.springboot";
        enableTableFieldAnnotation = false;
        tableIdType = null;
        generateByTablesWithInjectConfig(packageName, "sys_dept");
    }
}
