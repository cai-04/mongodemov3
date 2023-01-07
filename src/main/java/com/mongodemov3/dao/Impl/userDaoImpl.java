package com.mongodemov3.dao.Impl;

import com.mongodemov3.config.MongoDBAppender;
import com.mongodemov3.dao.userDao;
import com.mongodemov3.pojo.*;
import com.mongodemov3.service.Impl.userServiceImpl;
import com.mongodemov3.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class userDaoImpl implements userDao {

    private static Logger logger = LoggerFactory.getLogger(userServiceImpl.class);
    private static Logger logs = LoggerFactory.getLogger(CommonUtils.class);
    private static Logger los = LoggerFactory.getLogger(MongoDBAppender.class);
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void adduser(user user) {
        mongoTemplate.insert(user, "user");
    }

    @Override
    public void addexuser(UserExtendInfo userExtendInfo) {
        user user = new user();
        Query query = new Query(Criteria.where("_id").is(userExtendInfo.getId()));
        Update update = new Update();
        update.set("codeNum", userExtendInfo.getCodeNum());
        update.set("phone", userExtendInfo.getPhone());
        update.set("school", userExtendInfo.getSchool());
        update.set("address", userExtendInfo.getAddress());
        update.push("user", user);
        //mongoTemplate.insert(userExtendInfo,"user");
        mongoTemplate.upsert(query, update, user.class);
    }

    @Override
    public void addLogs(LogBean logBean) {
        Query query = new Query(Criteria.where("_id").is(logBean.getId()));
        Update update = new Update();
        update.push("(LogBean", logBean);
        //mongoTemplate.upsert(query, update, order.class);
        mongoTemplate.upsert(query, update, user.class);
    }


    @Override
    public user getUserById(int id) {
        Query query = new Query(Criteria.where("_id").is(id));
        user user = mongoTemplate.findOne(query, user.class);
        return user;
    }

    @Override
    public UserExtendInfo getUserexById(int id) {
        Query query = new Query(Criteria.where("_id").is(id));
        System.out.println(query);
        System.out.println(id);
        UserExtendInfo user = mongoTemplate.findOne(query, UserExtendInfo.class, "user");
        System.out.println(user);
        return user;
    }

    @Override
    public userall getUserallById(int id) {
        Query query = new Query(Criteria.where("_id").is(id));
        userall user = mongoTemplate.findOne(query, userall.class, "user");
        return user;
    }

    @Override
    public boolean deleteUserById(int id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, userall.class, "user");
        return true;
    }

    @Override
    public List<user> getAlluser() {
        List<user> list = mongoTemplate.findAll(user.class, "user");
        return list;
    }

    @Override
    public List<UserExtendInfo> getAllexuser() {
        List<UserExtendInfo> list = mongoTemplate.findAll(UserExtendInfo.class, "user");
        return list;
    }

    @Override
    public List<userall> getAlluserall() {
        List<userall> list = mongoTemplate.findAll(userall.class, "user");
        return list;
    }

    @Override
    public void editUser(int id, String nickname, int age, String sex) {
        user user = new user();
        Query query = new Query(Criteria.where("_id").is(id));
        System.out.println(query);
        Update update = new Update();
        update.set("nickname", nickname);
        update.set("age", age);
        update.set("sex", sex);
        System.out.println(update);
        mongoTemplate.upsert(query, update, "user");
    }

    @Override
    public void editexUser(int id, String phone, String school, String address) {
        UserExtendInfo userExtendInfo = new UserExtendInfo();
        Query query = new Query(Criteria.where("_id").is(id));
        System.out.println(query);
        Update update = new Update();
        update.set("phone", phone);
        update.set("school", school);
        update.set("address", address);
        System.out.println(update);
        mongoTemplate.upsert(query, update, "user");
    }
}
