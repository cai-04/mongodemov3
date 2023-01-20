package com.mongodemov3.log;

import com.mongodemov3.pojo.LogBean;

import java.util.List;

public interface logDao {
    List<LogBean> findlog();
}
