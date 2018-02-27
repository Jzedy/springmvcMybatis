package com.cn.jzedy.base.Utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by Jzedy on 2018/2/27
 */
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }

    public static Object getBeanByClass(Class clazz){
        return applicationContext.getBean(clazz);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
