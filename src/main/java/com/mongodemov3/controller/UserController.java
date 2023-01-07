package com.mongodemov3.controller;

import com.mongodemov3.config.MongoDBAppender;
import com.mongodemov3.pojo.*;
import com.mongodemov3.service.userService;
import com.mongodemov3.utils.CommonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "用户管理")
public class UserController {
    // 日志信息注入
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    private static Logger logs = LoggerFactory.getLogger(CommonUtils.class);
    private static Logger los = LoggerFactory.getLogger(MongoDBAppender.class);


    @Autowired
    userService userService;

    //添加用户基本信息
    @PostMapping("adduser")
    @ApiOperation(value = "添加用户基本信息")
    public String adduser(user user) {
        user.setCreateDate(new Date());
        userService.adduser(user);
        return "添加成功";
    }

    //添加用户拓展信息
    @PostMapping("addexuser")
    @ApiOperation(value = "添加用户拓展信息")
    public String addexuser(user user, UserExtendInfo userExtendInfo) {
        user.setExdateTime(new Date());
        userService.addexuser(userExtendInfo);
        return "添加成功";
    }

    //按id查找用户(基本信息)
    @GetMapping("getuserbyid")
    @ApiOperation(value = "按id查找用户(基本信息)")
    public user getUserById(int id) {
        user user = userService.getUserById(id);
        return user;
    }

    //按id查找用户(拓展信息)
    @GetMapping("getuserexbyid")
    @ApiOperation(value = "按id查找用户(拓展信息)")
    public UserExtendInfo getUserexById(int id) {
        UserExtendInfo userExtendInfo = userService.getUserexById(id);
        return userExtendInfo;
    }

    //按id查找用户(全部信息)
    @GetMapping("getuserallbyid")
    @ApiOperation(value = "按id查找用户(全部信息)")
    public userall getUserallByIdById(int id) {
        userall userall = userService.getUserallById(id);
        return userall;
    }


    //按id删除用户
    @GetMapping("deletebyuserid")
    @ApiOperation(value = "按id删除用户")
    public String deleteById(int id, Log log) {
        userService.deleteUserById(id);
        return "成功";
    }

    //展示用户基本信息
    @GetMapping("getalluser")
    @ApiOperation(value = "展示用户基本信息")
    public Map<String, Object> getAllUser() {
        Map<String, Object> map = new HashMap<>();
        List<user> list = userService.getAlluser();
        map.put("code", "0");
        map.put("count", list.size());
        map.put("data", list);
        return map;
    }

    //展示用户拓展信息
    @GetMapping("getallexuser")
    @ApiOperation(value = "展示用户拓展信息")
    public Map<String, Object> getAllexUser() {
        {
            Map<String, Object> map = new HashMap<>();
            List<UserExtendInfo> list = userService.getAllexuser();
            map.put("code", "0");
            map.put("count", list.size());
            map.put("data", list);
            return map;
        }
    }

    //展示用户所有信息
    @GetMapping("getalluserall")
    @ApiOperation(value = "展示用户所有信息")
    public Map<String, Object> getAllUserall() {
        Map<String, Object> map = new HashMap<>();
        List<userall> list = userService.getAlluserall();
        map.put("code", "0");
        map.put("count", list.size());
        map.put("data", list);
        return map;
    }

    //修改用户基本信息
    @PostMapping("edituser")
    @ApiOperation(value = "修改用户基本信息")
    public String editupdateuser(int id, String nickname, int age, String sex) {
        userService.editUser(id, nickname, age, sex);
        return "修改成功";
    }

    //修改用户拓展信息
    @PostMapping("editexuser")
    @ApiOperation(value = "修改用户拓展信息")
    public String editupdateexuser(int id, String phone, String school, String address) {
        userService.editexUser(id, phone, school, address);
        return "修改成功";
    }
}

