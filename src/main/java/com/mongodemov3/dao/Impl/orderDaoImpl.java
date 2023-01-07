package com.mongodemov3.dao.Impl;

import com.mongodemov3.config.MongoDBAppender;
import com.mongodemov3.dao.orderDao;
import com.mongodemov3.pojo.*;
import com.mongodemov3.service.Impl.orderServiceImpl;
import com.mongodemov3.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class orderDaoImpl implements orderDao {
    private static Logger logger = LoggerFactory.getLogger(orderServiceImpl.class);
    private static Logger logs = LoggerFactory.getLogger(CommonUtils.class);
    private static Logger log = LoggerFactory.getLogger(MongoDBAppender.class);
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void addorder(order order) {
        mongoTemplate.insert(order, "order");
        mongoTemplate.insert(order, "historyorder");
    }

    @Override
    public void addLogisticsAndUpdateStatus(Logistics logistics) {
        String status = logistics.getOperation();
        Query query = new Query(Criteria.where("_id").is(logistics.getOrderId()));
        Update update = new Update();
        update.set("status", status);//更新状态
        update.push("Logistics", logistics);
        mongoTemplate.upsert(query, update, order.class);
        mongoTemplate.upsert(query, update, historyorder.class);
        //mongoTemplate.upsert(query, update, user.class);
    }

    @Override
    public void addLogs(LogBean logBean) {
        Query query = new Query(Criteria.where("_id").is(logBean.getId()));
        Update update = new Update();
        update.push("(LogBean", logBean);
        mongoTemplate.upsert(query, update, order.class);
        //mongoTemplate.upsert(query, update, user.class);
    }


    @Override
    public order getOrderById(int id) {
        Query query = new Query(Criteria.where("_id").is(id));
        order order = mongoTemplate.findOne(query, order.class);
        return order;
    }

    @Override
    public boolean deleteOrderById(int id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, order.class, "order");
        return true;
    }

    @Override
    public List<order> getAllorder() {
        List<order> list = mongoTemplate.findAll(order.class, "order");
        return list;
    }

    @Override
    public List<historyorder> getAllHistoryorder() {
        List<historyorder> list = mongoTemplate.findAll(historyorder.class, "historyorder");
        return list;
    }

    @Override
    public historyorder getHistoryorderById(int id) {
        Query query = new Query(Criteria.where("_id").is(id));
        historyorder historyorder = mongoTemplate.findOne(query, historyorder.class);
        return historyorder;
    }

    @Override
    public void editOrder(int id, String recevier, String recevierAddress, long receviePhone) {
        order order = new order();

        Query query = new Query(Criteria.where("_id").is(id));
        //System.out.println(query);
        Update update = new Update();
        update.set("recevier", recevier);
        update.set("recevierAddress", recevierAddress);
        update.set("receviePhone", receviePhone);
        //System.out.println(update);
        mongoTemplate.upsert(query, update, "order");
        //mongoTemplate.findAndModify(query,update, order.class);
        //mongoTemplate.save(update,"order");
    }
}
