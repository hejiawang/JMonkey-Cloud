package com.wang.jmonkey.cloud.modules.upms.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 代码自动生成
 * @Auther: HeJiawang
 * @Date: 2018/7/23
 */
public class CodeGenerator {

    @Test
    public void codeGeneratorTest(){

        String outputDir = "D:/CodeGenerator";

        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(outputDir).setFileOverride(true).setActiveRecord(true).setEnableCache(false)
            .setBaseResultMap(true).setBaseColumnList(true).setAuthor("HeJiawang");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL).setDriverName("com.mysql.jdbc.Driver").setUsername("root").setPassword("123456")
            .setUrl("jdbc:mysql://114.116.89.11:3306/hjw_test?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setSuperControllerClass("com.wang.jmonkey.cloud.common.http.abs.BaseHttp").setNaming(NamingStrategy.underline_to_camel)
        .setInclude("sys_dept");
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.wang.jmonkey.cloud.modules.upms").setController("api").setEntity("model.entity");
        mpg.setPackageInfo(pc);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };
        // 生成的模版路径，不存在时需要先新建
        File viewDir = new File(outputDir);
        if (!viewDir.exists()) viewDir.mkdirs();

        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/Api.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {

                String path = outputDir + "/" + pc.getParent().replace(".", "/") + "/"+ pc.getController() + "/" + tableInfo.getEntityName() + "Api.java";
                File viewDir = new File(path).getParentFile();
                if (!viewDir.exists()) {
                    viewDir.mkdirs();
                }

                return path;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        mpg.execute();
    }
}
