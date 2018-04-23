package com.cn.jzedy.base.controller;

import com.cn.jzedy.base.response.ResponseContents;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jzedy on 2018/2/27
 */

@ControllerAdvice
public class BaseController {

    protected static final String REDIECT = "redirect:";


    @ModelAttribute
    public void getPath(HttpServletRequest request, Model model){
        model.addAttribute( "ctx", request.getContextPath() );
    }

    /**
     * 统一异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map errorHandler(Exception e){
        Map map = new HashMap();
        map.put("code", ResponseContents.KEY_ERROR);
        map.put("msg",e.getMessage());
        return map;
    }

}
