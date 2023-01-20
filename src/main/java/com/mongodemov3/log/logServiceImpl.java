package com.mongodemov3.log;

import com.mongodemov3.pojo.LogBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class logServiceImpl implements logService {
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    logDao logDao;

    @Override
    public List<LogBean> findlog() {
        return logDao.findlog();
    }
}
