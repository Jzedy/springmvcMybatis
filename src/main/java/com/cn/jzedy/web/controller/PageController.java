package com.cn.jzedy.web.controller;

import com.cn.jzedy.page.entity.Page;
import com.cn.jzedy.page.service.JdbcService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by Jzedy on 2018/4/12
 */
@Controller
@RequestMapping(value = "/page")
public class PageController {

    @Resource(name = "jdbcService")
    private JdbcService jdbcService;

    @RequestMapping(value = "/user")
    public String user(Model model){
        String sql = "select * from users";
        Page page = jdbcService.findPage(sql, null, 1, 2);
        model.addAttribute("data",page);
        return "page/user";
    }
}
