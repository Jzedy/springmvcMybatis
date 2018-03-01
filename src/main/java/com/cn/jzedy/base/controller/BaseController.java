package com.cn.jzedy.base.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Jzedy on 2018/2/27
 */

public class BaseController {

    protected static final String REDIECT = "redirect:";


    @ModelAttribute
    public void getPath(HttpServletRequest request, Model model){
        model.addAttribute( "ctx", request.getContextPath() );
    }

}
