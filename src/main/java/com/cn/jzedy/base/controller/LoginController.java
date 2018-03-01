package com.cn.jzedy.base.controller;

import com.cn.jzedy.common.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jzedy on 2018/3/1
 */
@Controller
public class LoginController extends BaseController{

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login(User user){
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(user.getUsername(),user.getPassword()));
        if (subject.isAuthenticated()){
            return REDIECT + "/user/findAll";
        }else return REDIECT + "/";
    }
}
