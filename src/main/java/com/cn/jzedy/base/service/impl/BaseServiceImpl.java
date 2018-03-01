package com.cn.jzedy.base.service.impl;

import com.cn.jzedy.base.Utils.SnowflakeIdWorker;
import com.cn.jzedy.base.eneity.BaseEntity;
import com.cn.jzedy.base.repository.BaseRepository;
import com.cn.jzedy.base.service.BaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Jzedy on 2018/2/27
 */
@Transactional(rollbackFor = {Exception.class})
public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    private BaseRepository<T> baseRepository;
    private Class<T> clazz;

    public BaseServiceImpl() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<T>) type.getActualTypeArguments()[0];
    }

    public void setBaseRepository(BaseRepository<T> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public int deleteById(String id) {
        return baseRepository.deleteByPrimaryKey(id);
    }


    @Override
    public T save(T entity) {
        if (StringUtils.isBlank(entity.getId())){
            SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(4, 4);
            entity.setId(String.valueOf(snowflakeIdWorker.nextId()));
        }
        T fromDB = this.findById(entity.getId());
        if (fromDB != null){
            fromDB = fillData(entity);
            baseRepository.updateByPrimaryKey(fromDB);
        }else{
            fromDB = entity;
            baseRepository.insert(entity);
        }

        return fromDB;
    }

    @Override
    public T findById(String id) {
        return baseRepository.selectByPrimaryKey(id);
    }

    @Override
    public List<T> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public List<T> findData(T entity) {
        return baseRepository.findData(entity);
    }

    private T fillData(T entity) {
        T fromDB = baseRepository.selectByPrimaryKey(entity.getId());
        if (fromDB != null) {
            for (Field field : clazz.getDeclaredFields()) {
                if (field.getType().getSuperclass() != BaseEntity.class) {
                    String fieldName = field.getName();
                    String setter = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    String getter = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    try {

                        Method setterMethod = clazz.getMethod(setter, field.getType());
                        Method getterMethod = clazz.getMethod(getter);
                        if (getterMethod.invoke(entity) != null) {
                            setterMethod.invoke(fromDB, getterMethod.invoke(entity));
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return fromDB;
    }

}
