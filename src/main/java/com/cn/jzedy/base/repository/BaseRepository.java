package com.cn.jzedy.base.repository;

import java.util.List;

/**
 * Created by Jzedy on 2018/2/27
 */
public interface BaseRepository<T> {

    int deleteByPrimaryKey(String id);

    int insert(T entity);

    int insertSelective(T entity);

    T selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(T entity);

    int updateByPrimaryKey(T entity);

    List<T> findAll();

    List<T> findData(T entity);

}
