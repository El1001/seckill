package com.example.seckill.controller;


import com.example.seckill.pojo.User;
import com.example.seckill.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ZEL
 * @since 2021-09-07
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    IUserService userService;

    @RequestMapping("/toList")
    public String toLogin(Model model, User user) {
//        这里 使用userArgumentResolver 来 优化登录问题
//        if (StringUtils.isEmpty(ticket)) {
//            return "login";
//        }
//        User user = userService.getByUserTicket(ticket,request,response);
//        if (null == user) {
//            return "login";
//        }
        model.addAttribute("user", user);
        return "goodsList";
    }
}
