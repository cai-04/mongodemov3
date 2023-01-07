package com.mongodemov3.service.Impl;

import com.mongodemov3.config.MongoDBAppender;
import com.mongodemov3.dao.userDao;
import com.mongodemov3.pojo.*;
import com.mongodemov3.service.userService;
import com.mongodemov3.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImpl implements userService {
    private static Logger logger = LoggerFactory.getLogger(userServiceImpl.class);
    private static Logger logs = LoggerFactory.getLogger(CommonUtils.class);
    private static Logger los = LoggerFactory.getLogger(MongoDBAppender.class);
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    userDao userDao;

    @Override
    public void adduser(user user) {

        userDao.adduser(user);
    }

    @Override
    public void addexuser(UserExtendInfo userExtendInfo) {
        userDao.addexuser(userExtendInfo);
    }


    @Override
    public void addLogs(LogBean logBean) {
        userDao.addLogs(logBean);
    }


    @Override
    public user getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public UserExtendInfo getUserexById(int id) {
        return userDao.getUserexById(id);
    }

    @Override
    public userall getUserallById(int id) {
        return userDao.getUserallById(id);
    }

    @Override
    public boolean deleteUserById(int id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public List<user> getAlluser() {
        return userDao.getAlluser();
    }

    @Override
    public List<UserExtendInfo> getAllexuser() {
        return userDao.getAllexuser();
    }

    @Override
    public List<userall> getAlluserall() {
        return userDao.getAlluserall();
    }

    @Override
    public void editUser(int id, String nickname, int age, String sex) {
        userDao.editUser(id, nickname, age, sex);
    }

    @Override
    public void editexUser(int id, String phone, String school, String address) {
        userDao.editexUser(id, phone, school, address);
    }
}
