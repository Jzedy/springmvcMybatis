package com.cn.jzedy.common.service.impl;

import com.cn.jzedy.base.service.impl.BaseServiceImpl;
import com.cn.jzedy.common.mapper.UsersMapper;
import com.cn.jzedy.common.model.User;
import com.cn.jzedy.common.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    private UsersMapper usersMapper;

    @Resource
    public void setUsersMapper(UsersMapper usersMapper) {
        super.setBaseRepository(usersMapper);
        this.usersMapper = usersMapper;
    }

    @Override
    public User getUserByUsername(String name) {
        return usersMapper.getUserByUsername(name);
    }
}
