package com.example.seckill.controller;

/**
 * @Author: EL Zhang
 * @DateTime: 2021-09-01 21:25
 * @Description:
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @author zhoubin
 * @since 1.0.0
 */
@RestController
@RequestMapping("/demo")
public class testController {
    /**
     * 测试页面跳转
     *
     * @return
     */
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

}
