# 项目结构：

本项目采用：前端（layui+jQuery），后端（springboot2.x），数据库（非关系型数据库mongodb）

本项目为mongo数据库大作业，对于一些基本模块的简单实现。代码放入码云仓库以及github。

[gitee仓库](https://gitee.com/Q0-3-0-8-_q-s-jQ/mongodemov3)

[github仓库](https://github.com/cai-04/mongodemov3)

# 项目说明：

## 1.系统入口说明：

[入口地址：http://127.0.0.1:3000](http://patorjk.com/software/taag/#p=display&f=Graffiti&t=Type%20Something%20)或者[入口（跳过登陆页面）](http://127.0.0.1:3000/system.html)

```
登录页面密码详见index.html 126行
我在这里的用户名密码配置为：if (name==="2013040544q" && pass==="qsj0308") 
具体的自己该，但需要遵守正则：用户名不能全为数字，用户名首尾不能出现下划线'_'，用户名不能有特殊字符，用户名不能为空
密码必须6到12位，且不能出现空格
这里为了简化项目而采用前端指定账号密码进行操作
这里没有做严格限制也可以通过http://127.0.0.1:3000/system.html进入这里只是为了测试方便而跳过登陆界面
```



## 2.依赖引入

```
本项目有Lombok,mongo,aop这几部分依赖组成，前两个依赖可以在创建springboot项目时引入，最后这个依赖引入如下：
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-aop</artifactId>
        </dependency>
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjrt</artifactId>
            <version>1.9.1</version>
        </dependency>
        
三个依赖：
  <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-aop</artifactId>
        </dependency>
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjrt</artifactId>
            <version>1.9.1</version>
        </dependency>
        
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-mongodb</artifactId>
        </dependency>
```

## 3.修改application.properties配置文件，增加mongo数据库连接

```
# mongodb数据库配置
spring.data.mongodb.uri=mongodb://localhost:27017/springboot
#这里的springboot为数据库名称自己先建好然后自己改
mongodb集合说明：
hsitoryorder:历史订单存储
logs:ip,方法，请求名称等日志存储
order:订单信息存储
user:用户信息存储
```

## 4.本项目实现的模块为：日志存储，订单信息管理，用户信息管理，历史订单四个模块

## 5.本项目存储 数据均存到mongodb中，日志信息采用logback日志框架存储，并在本地输出及存储

## 6.前端页面说明：位置均为static下

```
1.addlogistics.html：物流信息表单页面
2.addorder.html：添加订单信息表单页面
3.editexuser.html：修改用户拓展信息表单页面
4.editorder.html：修改订单信息表单页面
5.edituser.html：修改用户基本信息表单页面
6.hisordermanage.html：展示历史订单页面
7.index.html：登陆页面
8.ordermanage.html：订单信息管理页面
9.system.html：系统主页面
10.user.html：用户基本信息表单页面
11.userall.html：用户所有信息表单页面
12.userex.html：用户拓展信息表单页面
13.usermanager.html：展示用户基本信息页面
14.usermanagerdetails.html：展示用户拓展信息页面
16.log.html：日志信息展示
```

## 7.前端数据交互采用ajax异步交互

## 8.后端采用典型的springmvc架构实现，这里对一些包名进行说明

```
config:日志配置文件
pojo:实体类
utils:日志配置文件（IP类）
controller:controller控制层
service:service业务层
dao:dao层数据库操作层
log:日志读取层
```

## 9.logback配置文件，位置：src/main/resources/logback-spring.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<configuration debug="false" scan="true" scanPeriod="1 seconds">
<include resource="org/springframework/boot/logging/logback/base.xml" />
<!-- CONTEXT -->
<property name="CONTEXT_NAME" value="service" />
<contextName>${CONTEXT_NAME}</contextName>
<!-- 彩色日志配置 -->
<!-- 彩色日志依赖的渲染类 -->
<conversionRule conversionWord="clr" converterClass="org.springframework.boot.logging.logback.ColorConverter" />
<conversionRule conversionWord="wex" converterClass="org.springframework.boot.logging.logback.WhitespaceThrowableProxyConverter" />
<conversionRule conversionWord="wEx" converterClass="org.springframework.boot.logging.logback.ExtendedWhitespaceThrowableProxyConverter" />
<!-- 彩色日志格式 -->
<property name="CONSOLE_LOG_PATTERN" value="${CONSOLE_LOG_PATTERN:-%clr(%d{yyyy-MM-dd HH:mm:ss.SSS}){green} %clr(${LOG_LEVEL_PATTERN:-%5p}){red} %clr(${PID:-}){magenta} %clr(---){blue} %clr([%30.30t]){yellow} %clr(%-40.40logger{39}){cyan} %clr(:){blue} %m%n${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}}" />

<!-- 日志控制台输出设置 -->
<!-- %m输出的信息，%p日志级别，%t线程名，%d日期，%c类的全名 -->
<appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
    <encoder>
        <!-- <pattern>%d %p (%file:%line\)- %m%n</pattern> -->
        <pattern>${CONSOLE_LOG_PATTERN}</pattern>
        <charset>UTF-8</charset>
    </encoder>
</appender>

<!-- 文件输出设置 -->
<appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
    <file>../logs/${CONTEXT_NAME}/${CONTEXT_NAME}.log</file>
    <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
        <fileNamePattern>../logs/${CONTEXT_NAME}/${CONTEXT_NAME}.%d{yyyy-MM-dd}.log</fileNamePattern>
    </rollingPolicy>
    <encoder>
        <pattern>${CONSOLE_LOG_PATTERN}</pattern>
        <charset>UTF-8</charset>
    </encoder>
</appender>
<!-- mongoDB输出设置,此处是定义 -->
<appender name="MONGO" class="com.mongodemov3.config.MongoDBAppender">
    <host>127.0.0.1</host>
    <port>27017</port>
    <!-- <username>lzw</username> -->
    <!-- <password>123</password> -->
    <dbName>springboot</dbName>
    <collectionName>logdbs</collectionName>
    <source>${CONTEXT_NAME}</source>
    <filter class="ch.qos.logback.classic.filter.ThresholdFilter">
        <level>WARN</level>
    </filter>
</appender>

<!-- 总开关 -->
<root level="info">
    <!-- 	<appender-ref ref="CONSOLE" /> -->
    <appender-ref ref="FILE" />
    <appender-ref ref="MONGO" />
</root>

</configuration>
```

说明：这里的<!-- mongoDB输出设置,此处是定义 -->
<appender name="MONGO" class="com.mongodemov3.config.MongoDBAppender">，包名如果是自建项目需要改成自己的

## 10.layui的引入

引入后存放的位置，如果更改需要在代码里面也一起更改
static/layui
[layui下载地址：http://layui.org.cn/index.html](http://patorjk.com/software/taag/#p=display&f=Graffiti&t=Type%20Something%20)
下载完成后解压复制到对应项目的位置即可
jQuery：版本号：3.5.1
[下载地址：http://www.jq22.com/jquery/jquery-3.5.1.zip](http://patorjk.com/software/taag/#p=display&f=Graffiti&t=Type%20Something%20)
下载后只需要把jquery-3.5.1.min.js复制到项目中，注意只需要min即可，再static文件夹下新建js文件夹复制进去即可。
路径：static/js/jquery-3.5.1.min.js

## 11.swagger配置

引入依赖

这里这么麻烦是有个bug,Swagger2(2.9版本)集成springboot(2.3.7版本)出现Illegal DefaultValue null for parameter type
integer异常。需要我们处理一下。

```
<dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.9.2</version>
            <!--先是排除有问题的包-->
            <exclusions>
                <exclusion>
                    <groupId>io.swagger</groupId>
                    <artifactId>swagger-annotations</artifactId>
                </exclusion>
                <exclusion>
                    <groupId>io.swagger</groupId>
                    <artifactId>swagger-models</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.9.2</version>
        </dependency>
        <!--然后手动加入没问题的包-->
        <dependency>
            <groupId>io.swagger</groupId>
            <artifactId>swagger-annotations</artifactId>
            <version>1.5.21</version>
        </dependency>
        <dependency>
            <groupId>io.swagger</groupId>
            <artifactId>swagger-models</artifactId>
            <version>1.5.21</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.github.xiaoymin/knife4j-spring-boot-starter -->
        <dependency>
            <groupId>com.github.xiaoymin</groupId>
            <artifactId>knife4j-spring-boot-starter</artifactId>
            <version>2.0.9</version>
        </dependency>
```

Knife4jConfiguration.java

```
package com.mongodemov3.utils;


import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;
/**
 * swagger美化配置
 *
 *
 * */
@Configuration
@EnableSwagger2
@EnableKnife4j
public class Knife4jConfiguration {

    @Bean
    public Docket defaultApi2() {
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("mongodb大作业")
                        .description("springboot+mongodb+logback+layui+knife4j")
                        .contact(new Contact("cai4","127.0.0.1:3000/doc.html","2387717648@qq.com"))
                        .version("1.0")
                        .build())
                //分组名称
                .groupName("v3.0")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.mongodemov3.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}
```

说明：这里使用Knife4j为了美化swagger，原生的有点丑

[Knife4j文档访问地址：127.0.0.1:3000/doc.html](http://patorjk.com/software/taag/#p=display&f=Graffiti&t=Type%20Something%20)

## 12.springboot自定义图案启动

找到src/main/resources/banner.txt文件，更改里面的内容即可，内容可以访问[Text to ASCII Art Generator (TAAG) (patorjk.com)](http://patorjk.com/software/taag/#p=display&f=Graffiti&t=Type Something )生成，复制进去即可
