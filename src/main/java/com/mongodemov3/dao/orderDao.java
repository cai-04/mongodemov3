package com.mongodemov3.dao;

import com.mongodemov3.pojo.*;

import java.util.List;

public interface orderDao {
    //添加订单
    void addorder(order order);

    //添加物流日志信息
    void addLogisticsAndUpdateStatus(Logistics logistics);

    //添加日志信息：方法、请求名称、IP信息等
    void addLogs(LogBean logBean);

    //按照ID查找订单
    order getOrderById(int id);

    //按照ID删除订单
    boolean deleteOrderById(int id);

    //展示所有订单信息
    List<order> getAllorder();

    //历史订单
    List<historyorder> getAllHistoryorder();

    //按ID查找历史订单信息
    historyorder getHistoryorderById(int id);

    //修改订单信息
    void editOrder(int id, String recevier, String recevierAddress, long receviePhone);
}
