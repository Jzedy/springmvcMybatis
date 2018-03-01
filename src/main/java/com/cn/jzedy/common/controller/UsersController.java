package com.cn.jzedy.common.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.jzedy.base.controller.BaseController;
import com.cn.jzedy.base.response.ResponseData;
import com.cn.jzedy.common.model.Users;
import com.cn.jzedy.common.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UsersController extends BaseController{

    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping(value = "/findAll")
    public String findAll(Model model,Users users){
//        Users users = userService.findById("1");
        List<Users> usersList = userService.findData(users);
        System.out.println(JSONObject.toJSONString(usersList));
        model.addAttribute("username",users.getUsername());
        model.addAttribute("users",usersList);
        return "user/index";
    }

    @RequestMapping(value = "/addView")
    public String addView(Model model,Users user){
        Users users = userService.findById(user.getId());
        model.addAttribute("data",users);
        return "user/add";
    }

    @ResponseBody
    @RequestMapping(value = "/saveOrEdit")
    public ResponseData saveOrEdit(Model model, Users user){
        userService.save(user);
        return ResponseData.ok();
    }

}
