package com.cn.jzedy.web.controller;

import com.cn.jzedy.page.entity.Page;
import com.cn.jzedy.page.entity.PageQuery;
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
    public String user(Model model, PageQuery query){
        // TODO: 2018/4/13 前端对于页数过多时候没有处理
        String sql = "select * from users";
        Page page = jdbcService.findPage(sql, null, query.getPageNum(), query.getPageSize());
        model.addAttribute("data",page);
        return "page/user";
    }
}
