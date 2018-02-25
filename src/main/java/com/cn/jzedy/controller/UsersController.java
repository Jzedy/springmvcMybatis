package com.cn.jzedy.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.jzedy.model.Users;
import com.cn.jzedy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UsersController {

    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping(value = "/findAll")
    public String findAll(Model model,Users users){
//        Users users = userService.findById("1");
        List<Users> usersList = userService.findAll(users);
        System.out.println(JSONObject.toJSONString(usersList));
        model.addAttribute("username",users.getUsername());
        model.addAttribute("users",usersList);
        return "index";
    }
}
