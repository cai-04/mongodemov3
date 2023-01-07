package com.mongodemov3.service.Impl;

import com.mongodemov3.config.MongoDBAppender;
import com.mongodemov3.dao.orderDao;
import com.mongodemov3.pojo.*;
import com.mongodemov3.service.orderService;
import com.mongodemov3.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class orderServiceImpl implements orderService {
    private static Logger logger = LoggerFactory.getLogger(orderServiceImpl.class);
    private static Logger logs = LoggerFactory.getLogger(CommonUtils.class);
    private static Logger los = LoggerFactory.getLogger(MongoDBAppender.class);
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    orderDao orderDao;

    //创建订单，传来order对象
    public void addorder(order order) {
        orderDao.addorder(order);
    }


    //更新物流
    public void addLogisticsAndUpdateStatus(Logistics logistics) {
        orderDao.addLogisticsAndUpdateStatus(logistics);
    }

    @Override
    public void addLogs(LogBean logBean) {
        orderDao.addLogs(logBean);
    }


    //通过id查询物流
    public order getOrderById(int id) {
        return orderDao.getOrderById(id);
    }

    //根据id删除记录
    public boolean deleteOrderById(int id) {
        return orderDao.deleteOrderById(id);
    }

    //查询所有订单
    public List<order> getAllorder() {
        return orderDao.getAllorder();
    }

    @Override
    public List<historyorder> getAllHistoryorder() {
        return orderDao.getAllHistoryorder();
    }


    @Override
    public historyorder getHistoryorderById(int id) {
        return orderDao.getHistoryorderById(id);
    }

    @Override
    public void editOrder(int id, String recevier, String recevierAddress, long receviePhone) {
        orderDao.editOrder(id, recevier, recevierAddress, receviePhone);
    }

}
