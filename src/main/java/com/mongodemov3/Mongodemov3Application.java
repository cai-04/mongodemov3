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


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@Slf4j
public class Mongodemov3Application {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(Mongodemov3Application.class, args);
        log.info(" .----------------.  .----------------.  .----------------.  .----------------. \n" +
                "| .--------------. || .--------------. || .--------------. || .--------------. |\n" +
                "| |     ______   | || |      __      | || |     _____    | || |   _    _     | |\n" +
                "| |   .' ___  |  | || |     /  \\     | || |    |_   _|   | || |  | |  | |    | |\n" +
                "| |  / .'   \\_|  | || |    / /\\ \\    | || |      | |     | || |  | |__| |_   | |\n" +
                "| |  | |         | || |   / ____ \\   | || |      | |     | || |  |____   _|  | |\n" +
                "| |  \\ `.___.'\\  | || | _/ /    \\ \\_ | || |     _| |_    | || |      _| |_   | |\n" +
                "| |   `._____.'  | || ||____|  |____|| || |    |_____|   | || |     |_____|  | |\n" +
                "| |              | || |              | || |              | || |              | |\n" +
                "| '--------------' || '--------------' || '--------------' || '--------------' |\n" +
                " '----------------'  '----------------'  '----------------'  '----------------' ");
        Environment env = application.getEnvironment();
        String port = env.getProperty("server.port");
        String path1 = env.getProperty("server.servlet.context-path");
        String path2 = env.getProperty("server.servlet.context-path");
        if (StringUtils.isEmpty(path1)) {
            path1 = "system.html";
        }
        if (StringUtils.isEmpty(path2)) {
            path2 = "doc.html";
        }
        log.info("\n----------------------------------------------------------\n\t" +
                "Application  is running! Access URLs:\n\t" +
                "Local访问网址: \t\thttp://localhost:" + port  + "\n\t" +
                "Local跳过登陆页面访问网址: \t\thttp://localhost:" + port + "/" + path1 + "\n\t" +
                "Knife4j文档地址：\thttp://localhost" +  ":" + port + "/" + path2 + "\n\t" +
                "----------------------------------------------------------");
    }

}

    }

}
