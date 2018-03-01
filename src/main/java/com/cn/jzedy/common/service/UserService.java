package com.cn.jzedy.common.service;

import com.cn.jzedy.base.service.BaseService;
import com.cn.jzedy.common.model.User;

public interface UserService extends BaseService<User> {
    User getUserByUsername(String name);
}
