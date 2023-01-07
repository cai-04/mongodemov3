package com.mongodemov3;
/**
 * 版本v3
 * 2022/11/22 23:08
 * springboot+mongo电商系统
 * 模块实现：日志存储，订单管理，用户信息管理，历史订单
 * <p>
 * 版本v4
 * 2022/11/24 17:35
 * springboot+mongo电商系统
 * 模块实现：日志存储，订单管理，用户信息管理，历史订单
 * 修改内容：将service层拆分为dao层+service层，修改用户日志存储,日志控制台彩色打印输出
 * <p>
 * 版本v5
 * 2022/11-26 18：29
 * springboot+mongo电商系统
 * 模块实现：日志存储，订单管理，用户信息管理，历史订单
 * 修改内容：实现了通过id查找用户，修改了部分函数名称
 */

/**
 * 版本v4
 * 2022/11/24 17:35
 * springboot+mongo电商系统
 * 模块实现：日志存储，订单管理，用户信息管理，历史订单
 * 修改内容：将service层拆分为dao层+service层，修改用户日志存储,日志控制台彩色打印输出
 * */

/**
 * 版本v5
 * 2022/11-26 18：29
 * springboot+mongo电商系统
 * 模块实现：日志存储，订单管理，用户信息管理，历史订单
 * 修改内容：实现了通过id查找用户，修改了部分函数名称
 * */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Mongodemov3Application {

    public static void main(String[] args) {
        SpringApplication.run(Mongodemov3Application.class, args);
        System.out.println("------------------------------------");
        System.out.println("入口地址：http://127.0.0.1:3000");
        System.out.println("------------------------------------");
        System.out.println("或者 http://127.0.0.1:3000/system.html");
        System.out.println("！-- 第二个入口地址可跳过登陆页面 --！");
        System.out.println("------------------------------------");
        System.out.println("Knife4j文档地址：http://127.0.0.1:3000/doc.html");
        System.out.println("------------------------------------");
    }

}
