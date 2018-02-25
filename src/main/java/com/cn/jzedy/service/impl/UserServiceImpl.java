package com.cn.jzedy.service.impl;

import com.cn.jzedy.mapper.UsersMapper;
import com.cn.jzedy.model.Users;
import com.cn.jzedy.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public List<Users> findAll() {
        return usersMapper.findAll();
    }

    @Override
    public Users findById(String id) {
        return usersMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Users> findAll(Users users) {
        return usersMapper.findByUser(users);
    }
}
