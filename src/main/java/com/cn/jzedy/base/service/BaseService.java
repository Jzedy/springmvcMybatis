package com.cn.jzedy.base.service;

import com.cn.jzedy.base.eneity.BaseEntity;

import java.util.List;

/**
 * Created by Jzedy on 2018/2/27
 */
public interface BaseService<T extends BaseEntity> {

    int deleteById(String id);


    T save(T entity);

    T findById(String id);

    List<T> findAll();

    List<T> findData(T entity);
}
