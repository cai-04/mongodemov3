package com.mongodemov3.controller;

import com.mongodemov3.config.MongoDBAppender;
import com.mongodemov3.pojo.*;
import com.mongodemov3.service.orderService;
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
@Api(tags = "订单管理")
public class OrderController {
    // 日志信息注入
    private static Logger logger = LoggerFactory.getLogger(OrderController.class);
    private static Logger logs = LoggerFactory.getLogger(CommonUtils.class);
    private static Logger los = LoggerFactory.getLogger(MongoDBAppender.class);

    @Autowired
    orderService orderService;

    // 添加订单信息
    @PostMapping("addorder")
    @ApiOperation(value = "添加订单信息")
    public String addorder(order order) {

        order.setStatus("发货中");
        order.setOrderTime(new Date());
        order.setShipTime(new Date());
        orderService.addorder(order);
        return "添加成功";
    }

    // 添加物流信息
    @PostMapping("updateorder")
    @ApiOperation(value = "添加物流信息")
    public String updateorder(Logistics logistics) {
        logistics.setOperationTime(new Date());
        orderService.addLogisticsAndUpdateStatus(logistics);
        return "添加成功";
    }

    // 修改订单信息
    @PostMapping("editorder")
    @ApiOperation(value = "修改订单信息")
    public String editupdateorder(int id, String recevier, String recevierAddress, long receviePhone) {
        orderService.editOrder(id, recevier, recevierAddress, receviePhone);
        return "修改成功";
    }

    //按id查找订单信息
    @GetMapping("getorderbyid")
    @ApiOperation(value = "按id查找订单信息")
    public order getOrderById(int id) {
        order order = orderService.getOrderById(id);
        return order;
    }

    //按id删除订单信息
    @GetMapping("deletebyid")
    @ApiOperation(value = "按id删除订单信息")
    public String deleteById(int id) {
        orderService.deleteOrderById(id);
        return "成功";
    }

    //展示订单信息
    @GetMapping("getallorders")
    @ApiOperation(value = "展示订单信息")
    public Map<String, Object> getAllOrder() {
        Map<String, Object> map = new HashMap<>();
        List<order> list = orderService.getAllorder();
        map.put("code", "0");
        map.put("count", list.size());
        map.put("data", list);
        return map;
    }

    //通过id查找历史订单信息
    @GetMapping("gethistoryorderbyid")
    @ApiOperation(value = "通过id查找历史订单信息")
    public historyorder getHistoryOrderById(int id) {
        historyorder historyorder = orderService.getHistoryorderById(id);
        return historyorder;
    }

    // 展示所有历史订单信息
    @GetMapping("getallhistoryorders")
    @ApiOperation(value = "展示所有历史订单信息")
    public Map<String, Object> getAllHistoryOrder() {
        Map<String, Object> map = new HashMap<>();
        List<historyorder> list = orderService.getAllHistoryorder();
        map.put("code", "0");
        map.put("count", list.size());
        map.put("data", list);
        return map;
    }
}

