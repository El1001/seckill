package com.example.seckill.controller;

import com.example.seckill.mapper.UserMapper;
import com.example.seckill.pojo.User;
import com.example.seckill.service.IUserService;
import com.example.seckill.util.MD5Util;
import com.example.seckill.vo.LoginVo;
import com.example.seckill.vo.RespBean;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试类
 *
 * @author admin
 * @date 2021年 09月07日 17:35:15
 */
@RestController
public class Test {
    @Autowired
    IUserService userService;

    @RequestMapping("/insert")
    public RespBean regular(User userInput) {

        User user = new User();
        Long tel = new Long(Long.valueOf("13911111110"));
        user.setId(tel);
        user.setSlat("1a2b3c4d");
        user.setNickname("王二");
        String inputpassword = "123123";
        String password = MD5Util.inputPassToDBPass(inputpassword, user.getSlat());
        user.setPassword(password);
        userService.save(user);
        System.out.println(user);
        return RespBean.success("ok");
    }
}
