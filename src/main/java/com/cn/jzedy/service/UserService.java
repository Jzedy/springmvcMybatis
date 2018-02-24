package com.cn.jzedy.service;

import com.cn.jzedy.model.Users;

import java.util.List;

public interface UserService {
    List<Users> findAll();

    Users findById(String id);
}
