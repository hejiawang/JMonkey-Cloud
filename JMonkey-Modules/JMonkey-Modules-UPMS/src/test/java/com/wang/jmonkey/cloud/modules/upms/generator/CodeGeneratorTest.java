package com.wang.jmonkey.cloud.modules.upms.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

import java.util.List;

/**
 * @Description: 代码生成
 * @Auther: HeJiawang
 * @Date: 2018/7/24
 */
public class CodeGeneratorTest {

    @Test
    public void codeGeneratorTest(){
        autoGenerator().execute();
    }

    private AutoGenerator autoGenerator(){
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig())
                .setTemplate(templateConfig())
                .setDataSource(dataSourceConfig())
                .setStrategy(strategyConfig())
                .setPackageInfo( packageConfig());

        return autoGenerator;
    }

    private GlobalConfig globalConfig(){
        GlobalConfig config = new GlobalConfig();
        config.setControllerName("%sApi")
                .setAuthor("HeJiawang")
                .setBaseResultMap(true)
                .setOutputDir("D:/CodeGenerator")
                .setActiveRecord(true)
                .setEnableCache(false)
                .setFileOverride(true);

        return config;
    }

    private DataSourceConfig dataSourceConfig(){
        DataSourceConfig config = new DataSourceConfig();
        config.setDbType(DbType.MYSQL)
                .setUrl("jdbc:mysql://114.116.89.11:3306/hjw_test?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false")
                .setUsername("root").setPassword("123456").setDriverName("com.mysql.jdbc.Driver");

        return config;
    }

    private StrategyConfig strategyConfig(){
        StrategyConfig config = new StrategyConfig();
        config.setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setSuperEntityClass("com.wang.jmonkey.cloud.common.model.BaseEntity")
                .setSuperEntityColumns(new String[]{"create_date", "create_by", "update_date", "update_by", "delete_flag", "remark"})
                .setEntityLombokModel(true)
                .setInclude("sys_dept");

        return config;
    }

    private TemplateConfig templateConfig(){
        TemplateConfig config = new TemplateConfig();
        config.setController("/templates/Api.java");

        return config;
    }

    private PackageConfig packageConfig(){
        PackageConfig config = new PackageConfig();
        config.setParent("com")
                .setController("api")
                .setEntity("model.entity");
        return config;
    }

    @Test
    public void configBuilderTest(){
        ConfigBuilder builder = new ConfigBuilder(null, dataSourceConfig(), null, null, null );
        List<TableInfo> tableInfoList = builder.getTableInfoList();
        System.out.println(tableInfoList.size());
    }
}
