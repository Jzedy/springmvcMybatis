package com.cn.jzedy.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.jzedy.model.Users;
import com.cn.jzedy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class UsersController {

    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping(value = "/findAll")
    public String findAll(){
        Users users = userService.findById("1");
        System.out.println(JSONObject.toJSONString(users));
        return "index";
    }
}
