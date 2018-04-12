package com.cn.jzedy.page.service;


import com.cn.jzedy.page.entity.Page;

/**
 * Created by Jzedy on 2018/4/10
 */
public interface JdbcService {
    Page findPage(String sql, Object[] params, int pageNum, int pageSize);
}
