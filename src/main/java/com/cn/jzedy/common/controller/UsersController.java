package com.cn.jzedy.common.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.jzedy.base.controller.BaseController;
import com.cn.jzedy.base.response.ResponseData;
import com.cn.jzedy.common.model.User;
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

    /**
     * 条件查询所有
     * @param model
     * @param users
     * @return
     */
    @RequestMapping(value = "/findAll")
    public String findAll(Model model,User users){
//        Users users = userService.findById("1");
        List<User> usersList = userService.findData(users);
        System.out.println(JSONObject.toJSONString(usersList));
        model.addAttribute("username",users.getUsername());
        model.addAttribute("users",usersList);
        return "user/index";
    }

    /**
     * 跳转到添加界面
     * @param model
     * @param user
     * @return
     */
    @RequestMapping(value = "/addView")
    public String addView(Model model,User user){
        User users = userService.findById(user.getId());
        model.addAttribute("data",users);
        return "user/add";
    }

    /**
     * 保存或修改
     * @param model
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/saveOrEdit")
    public ResponseData saveOrEdit(Model model, User user){
        userService.save(user);
        return ResponseData.ok();
    }

    /**
     * 删除方法
     * @param users
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete")
    public ResponseData delete(User users){
        userService.deleteById(users.getId());
        return ResponseData.ok();
    }

}
