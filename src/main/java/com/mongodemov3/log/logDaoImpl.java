package com.mongodemov3.log;

import com.mongodemov3.pojo.LogBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class logDaoImpl implements logDao {
    @Autowired
    MongoTemplate mongoTemplate;


    @Override
    public List<LogBean> findlog() {
        List<LogBean> list = mongoTemplate.findAll(LogBean.class, "logs");
        return list;
    }


}
