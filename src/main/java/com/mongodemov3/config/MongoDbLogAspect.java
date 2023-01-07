package com.mongodemov3.config;

import com.mongodemov3.pojo.LogBean;
import com.mongodemov3.utils.CommonUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@Aspect
public class MongoDbLogAspect {
    @Autowired
    private MongoTemplate mongoTemplate;

    //切点的注解  是指那些方法需要被执行"AOP"
    @Pointcut("execution(* com.mongodemov3.controller.*.*(..))")
    public void logPointCut() {

    }

    //返回后通知value="logPointCut()"是指通知是在logPointCut()切点返回后通知的
    //returning="rtv"是返回值
    //@AfterReturning这个注解是返回后通知的注解
    @AfterReturning(value = "logPointCut()", returning = "rtv")
    //JoinPoint是连接点的意思我们要获取到的如类名，方法名，请求参数等都是从连接点中取出来的
    public void afterLog(JoinPoint joinpoint, Object rtv) {
        System.out.println("进去切点。。。。。");
        LogBean logBean = new LogBean();
        //获取类名
        String classname = joinpoint.getTarget().getClass().getSimpleName();
        //获取方法名
        String method = joinpoint.getSignature().getName();
        //获取请求参数
        String requestParam = "";
        logBean.setClassName(classname);
        logBean.setMethod(method);
        logBean.setResponseResults(requestParam);
        logBean.setCreateDate(new Date());
        //返回值
        if (rtv != null) {
            logBean.setResponseResults(rtv.toString());
        }
        //获取request对象
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String requestURI = request.getRequestURI();
        logBean.setRequestURI(requestURI);
		/*	UserBean user = (UserBean) request.getSession().getAttribute("user");
		if(user!=null){
			logBean.setUserId(user.getId());
		}*/
        //获取ip地址是封装好的一个类
        String ip = CommonUtils.getUserIP(request);
        logBean.setIp(ip);
//        user user = (user) SecurityUtils.getSubject().getPrincipal();
//        logBean.setUsername(user.getName());
        //保存mongodb
        mongoTemplate.save(logBean);
        System.out.println("日志存储成功.........");
    }
}
