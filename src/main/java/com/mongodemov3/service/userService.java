package com.mongodemov3.service;

import com.mongodemov3.pojo.*;

import java.util.List;

public interface userService {
    //添加用户基本信息
    void adduser(user user);

    //添加用户拓展信息
    void addexuser(UserExtendInfo userExtendInfo);

    //添加日志信息：方法、请求名称、IP信息等
    void addLogs(LogBean logBean);

    //按ID查找用户(基本信息)
    user getUserById(int id);

    //按ID查找用户(拓展信息)
    UserExtendInfo getUserexById(int id);

    //按ID查找用户(全部信息)
    userall getUserallById(int id);

    //按ID删除用户信息
    boolean deleteUserById(int id);

    //展示所有用户基本信息
    List<user> getAlluser();

    //展示用户拓展信息
    List<UserExtendInfo> getAllexuser();

    //展示用户所有信息
    List<userall> getAlluserall();

    //修改用户基本信息
    void editUser(int id, String nickname, int age, String sex);

    //修改用户拓展信息
    void editexUser(int id, String phone, String school, String address);
}
