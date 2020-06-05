package com.example.testauto.demo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
@SpringBootTest
public class CodeGenerator {


    private static String author = "haoliu";
    private static String outputDir = "E:\\GeneratedCode\\";
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/ctkb_new?useUnicode=true&characterEncoding=utf8";
    private static String username = "root";
    private static String password = "12345";
    private static String tablePrefix = "ec_";
    private static String parentPackage = "edu.columbia.cwlab.ctkbnew";
    private static String [] tables = {"ec_coronavirus_criteria", "ec_common_condition"};
    private static String dao = "dao";
    private static String service = "service";
    private static String entity = "entity";
    private static String controller = "controller";
    private static String mapperxml = "dao";


    @Test
    public void testGenerator() {


        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setAuthor(author)
                .setOutputDir(outputDir)
                .setFileOverride(true)
                .setIdType(IdType.AUTO)
                .setServiceName("%sService")
                .setBaseResultMap(true)
                .setBaseColumnList(true);


        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL)
                .setDriverName(driver)
                .setUrl(url)
                .setUsername(username)
                .setPassword(password);


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                .setInclude(tables)
                .setControllerMappingHyphenStyle(true)
                .setTablePrefix(tablePrefix);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(parentPackage)
                .setMapper(dao)
                .setService(service)
                .setController(controller)
                .setEntity(entity)
                .setXml(mapperxml);



        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();


        mpg.setGlobalConfig(gc)
                .setStrategy(strategy)
                .setDataSource(dsc)
                .setPackageInfo(pc);

        mpg.execute();
    }

}
