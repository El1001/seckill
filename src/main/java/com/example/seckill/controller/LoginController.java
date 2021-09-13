package com.example.seckill.controller;

import com.example.seckill.service.IUserService;
import com.example.seckill.vo.LoginVo;
import com.example.seckill.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * 登录
 *
 * @author admin
 * @date 2021年 09月07日 12:08:56
 */
@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {
    @Autowired
    IUserService userService;

    /**
     * 登录跳转页
     *
     * @return 跳转到登录
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public RespBean doLogin(HttpServletRequest request, HttpServletResponse response, @Valid LoginVo loginVo) {
        return userService.login(request, response, loginVo);
    }
}
